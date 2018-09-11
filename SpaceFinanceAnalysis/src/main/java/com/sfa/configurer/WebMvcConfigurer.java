package com.sfa.configurer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.sfa.core.Result;
import com.sfa.core.ResultCode;
import com.sfa.core.ServiceException;
import com.sfa.util.RequestWrapperHelper;
import com.sfa.util.ResourceConfigure;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Spring MVC 配置
 *
 * @author David
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    //当前激活的配置文件
    @Value("${spring.profiles.active}")
    private String env;

    //密钥，需自行修改
    @Value("${api.secret}")
    private String secret;

    /**
     * 使用阿里 FastJson 作为JSON MessageConverter
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        FastJsonConfig config = new FastJsonConfig();

        config.setSerializerFeatures(
                //保留空的字段
                SerializerFeature.WriteMapNullValue,
                //String null -> ""
                SerializerFeature.WriteNullStringAsEmpty,
                //Number null -> 0
                SerializerFeature.WriteNullNumberAsZero,
                //禁用FastJson循环引用检测特性
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }


    /**
     * 统一异常处理
     *
     * @param exceptionResolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
                Result result = new Result();
                //业务失败的异常，如“账号或密码错误”
                if (e instanceof ServiceException) {
                    result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
                    logger.info(e.getMessage());
                } else if (e instanceof NoHandlerFoundException) {
                    result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
                } else if (e instanceof ServletException) {
                    result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
                } else {
                    result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                    String message;
                    if (handler instanceof HandlerMethod) {
                        HandlerMethod handlerMethod = (HandlerMethod) handler;
                        message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                                request.getRequestURI(),
                                handlerMethod.getBean().getClass().getName(),
                                handlerMethod.getMethod().getName(),
                                e.getMessage());
                    } else {
                        message = e.getMessage();
                    }
                    logger.error(message, e);
                }
                responseResult(response, result);
                return new ModelAndView();
            }

        });
    }

    //解决跨域问题
    /**
     * JSONP跨域，script标签请求资源不受同源策略限制 只能用于get类型
     * CORS跨域
     * 
     * Cors
     * CORS是一个w3c标准,全称是"跨域资源共享"(Cross-origin resource sharing),
     * 但一个请求url的协议,域名,端口三者之间任意与当前页面地址不同即为跨域.
     * 它允许阅览器向跨源服务器发送ajax请求,从而克服AJAX只能同源使用的限制.
     * （1) 请求方法是以下三种方法之一：

			HEAD
			GET
			POST
			（2）HTTP的头信息不超出以下几种字段：
			
			Accept
			Accept-Language
			Content-Language
			Last-Event-ID
			Content-Type：只限于三个值application/x-www-form-urlencoded、multipart/form-data、text/plain
     * 
     * 使用 CORS，其实主要都是服务器端的配置，都是设置一系列的响应头 (Response Headers)
       Access-Control-Allow-Origin:  http://www.YOURDOMAIN.com             // 设置允许请求的域名，多个域名以逗号分隔
       Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS       // 设置允许请求的方法，多个方法以逗号分隔
       Access-Control-Allow-Headers: Authorization                         // 设置允许请求自定义的请求头字段，多个字段以逗号分隔
       Access-Control-Allow-Credentials: true                              // 设置是否允许发送 Cookies
     * ajax 同源策略
     *  同域资源可读写; 
		跨域请求会直接被浏览器拦截.
		(chrome下跨域请求不会发起, 其他浏览器一般是可发送跨域请求, 但响应被浏览器拦截)
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //接口签名认证拦截器，该签名认证比较简单，实际项目中可以使用Json Web Token或其他更好的方式替代。
        //开发环境忽略签名认证
        if (!"dev".equals(env)) {

            registry.addInterceptor(new HandlerInterceptorAdapter() {
                @Override
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                    //验证签名
                    boolean pass = validateSign(request);
                    if (pass) {
                        System.out.println("签名认证成功");
                        return true;
                    } else {
                        logger.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}",
                                request.getRequestURI(), getIpAddress(request), JSON.toJSONString(request.getParameterMap()));

                        Result result = new Result();
                        result.setCode(ResultCode.UNAUTHORIZED).setMessage("签名认证失败");
                        responseResult(response, result);
                        return false;
                    }
                }
            });
        }
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setHeader("Access-Control-Allow-Origin", ResourceConfigure.CLIENT_HOST);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 一个简单的签名认证，规则：
     * 1. 将请求参数按ascii码排序
     * 2. 拼接为a=value&b=value...这样的字符串（不包含sign）
     * 3. 混合密钥（secret）进行md5获得签名，与请求的签名进行比较
     */
    private boolean validateSign(HttpServletRequest request) throws IOException {
        //获得请求签名，如sign=19e907700db7ad91318424a97c54ed57
        String requestSign = request.getParameter("sign");
        if (StringUtils.isEmpty(requestSign)) {
            //验证RequestBody中的数据
            return validateRequestBodySign(request);
        }
        List<String> keys = new ArrayList<String>(request.getParameterMap().keySet());
        //排除sign参数
        keys.remove("sign");
        //排序
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            //拼接字符串
            sb.append(key).append("=").append(request.getParameter(key)).append("&");
        }
        String linkString = sb.toString();
        //去除最后一个'&'
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);

        //混合密钥md5
        String sign = DigestUtils.md5Hex(linkString + secret);

        //比较
        return StringUtils.equals(sign, requestSign);
    }

    /**
     * 验证RequestBody中参数的加密是否正确
     * 验证过程与validateSign(HttpServletRequest request)方法相同
     *
     * @param request
     * @return
     * @throws IOException
     */
    private boolean validateRequestBodySign(HttpServletRequest request) throws IOException {
        //获取RequestBody中的数据
        RequestWrapperHelper requestWrapperHelper = new RequestWrapperHelper(request);
        String requestBody = requestWrapperHelper.getRequestBody();
        if (StringUtils.isEmpty(requestBody)) {
            return false;
        }
        try {
            JSONObject requestJson = JSON.parseObject(requestBody);
            //获得请求签名，如sign=19e907700db7ad91318424a97c54ed57
            String requestSign = requestJson.getString("sign");
            if (StringUtils.isEmpty(requestSign)) {
                return false;
            }
            List<String> keys = new ArrayList<String>(requestJson.keySet());
            //排除sign参数
            keys.remove("sign");
            //排序
            Collections.sort(keys);

            StringBuilder sb = new StringBuilder();
            for (String key : keys) {
                //拼接字符串
                sb.append(key).append("=").append(requestJson.get(key)).append("&");
            }
            String linkString = sb.toString();
            //去除最后一个'&'
            linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);

            //混合密钥md5
            String sign = DigestUtils.md5Hex(linkString + secret);

            //比较
            return StringUtils.equals(sign, requestSign);
        } catch (Exception e) {
            System.out.println(e.toString() + " : " + e.getMessage() + "RequestBody数据验证时，数据出现异常");
            return false;
        }

    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 如果是多级代理，那么取第一个ip为客户端ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }

        return ip;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    /*    registry.addResourceHandler("/download/**")
                .addResourceLocations("file:D:/Workspaces/Test/productRemoval/download/");*/
    }
}
