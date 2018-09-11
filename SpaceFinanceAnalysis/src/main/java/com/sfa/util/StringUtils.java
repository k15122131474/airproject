package com.sfa.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 工具类
 * @author liuchanglong
 * 2017/12/4
 */
public class StringUtils {
    /**
     * @see: 验证string类型的是否为空
     */
    public static boolean isNullorEmpty(String str) {
        //为了执行忽略大小写的比较，可以调用equalsIgnoreCase( )方法。当比较两个字符串时，它会认为A-Z和a-z是一样的。
        if ((str == null) || ("".equals(str)) || ("null".equalsIgnoreCase(str)) || ("undefined".equalsIgnoreCase(str))) {
            return true;
        }
        return false;
    }

    /**
     * @see: 验证实体是否为空
     */
    public static <T> boolean isNullorEmpty(T entity) {
        if (entity == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @see: 验证StringBuffer类型的是否为空
     */
    public static boolean isNullorEmpty(StringBuffer str) {
        if (str == null ||"".equals(str.toString())  || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @see: 验证Map类型的是否为空
     */
    public static boolean isNullorEmpty(Map map) {
        if ((map == null) || (map.size() == 0)) {
            return true;
        }
        return false;
    }



    /**
     * @see: 验证Object数组类型的是否为空
     */
    public static boolean isNullorEmpty(Object[] obj) {
        if ((obj == null) || (obj.length == 0)) {
            return true;
        }
        return false;
    }

    /**
     * @see: 验证Long类型的是否为空
     */
    public static boolean isNullorEmpty(Long longTime) {
        if ((longTime == null) || (longTime.longValue() <= 0L)) {
            return true;
        }
        return false;
    }

    /**
     * 字符串防注入
     */

    //过滤通过页面表单提交的字符
    private static String[][] FilterChars={{"<","&lt;"},{">","&gt;"},{" ","&nbsp;"},{"\"","&quot;"},{"&","&amp;"},
            {"/","&#47;"},{"\\","&#92;"},{"\n","<br>"}};
    //过滤通过javascript脚本处理并提交的字符
    private static String[][] FilterScriptChars={{"\n","\'+\'\\n\'+\'"},
            {"\r"," "},{"\\","\'+\'\\\\\'+\'"},
            {"\'","\'+\'\\\'\'+\'"}};

    /**
     * 用特殊的字符连接字符串
     * @param strings 要连接的字符串数组
     * @param spilit_sign 连接字符
     * @return 连接字符串
     */
    public static String stringConnect(String[] strings,String spilit_sign){
        String str="";
        for(int i=0;i<strings.length;i++){
            str+=strings[i]+spilit_sign;
        }
        return str;
    }

    /**
     * 过滤字符串里的的特殊字符
     * @param str 要过滤的字符串
     * @return 过滤后的字符串
     */
    public static String stringFilter(String str){
        String[] str_arr=stringSpilit(str,"");
        for(int i=0;i<str_arr.length;i++){
            for(int j=0;j<FilterChars.length;j++){
                if(FilterChars[j][0].equals(str_arr[i])){
                    str_arr[i]=FilterChars[j][1];
                }

            }
        }
        return (stringConnect(str_arr,"")).trim();
    }

    /**
     * 过滤脚本中的特殊字符（包括回车符(\n)和换行符(\r)）
     * @param str 要进行过滤的字符串
     * @return 过滤后的字符串
     *
     */
    public static String stringFilterScriptChar(String str){
        String[] str_arr=stringSpilit(str,"");
        for(int i=0;i<str_arr.length;i++){
            for (int j = 0; j < FilterScriptChars.length; j++) {
                if (FilterScriptChars[j][0].equals(str_arr[i])){
                    str_arr[i] = FilterScriptChars[j][1];
                }

            }
        }
        return(stringConnect(str_arr,"")).trim();
    }


    /**
     * 分割字符串
     * @param str 要分割的字符串
     * @param spilit_sign 字符串的分割标志
     * @return 分割后得到的字符串数组
     */
    public static String[] stringSpilit(String str,String spilit_sign){
        String[] spilit_string=str.split(spilit_sign);
        if(spilit_string[0].equals(""))
        {
            String[] new_string=new String[spilit_string.length-1];
            for(int i=1;i<spilit_string.length;i++){
                new_string[i-1]=spilit_string[i];
            }

            return new_string;
        }
        else{
            return spilit_string;
        }

    }

    /**
     * 字符串字符集转换
     * @param str 要转换的字符串
     * @return 转换过的字符串
     */
    public static String stringTransCharset(String str){
        String new_str=null;
        try{
            new_str=new String(str.getBytes("iso-8859-1"),"GBK");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new_str;
    }
    
    /**
     * Excel文件名转换
     * @param fileNames
     * @param request
     * @return
     */
    public static String encodeFileName(String fileNames ,HttpServletRequest request) {
        String codedFilename = null;
        try {
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && -1 != agent.indexOf("MSIE") || null != agent
                    && -1 != agent.indexOf("Trident") || null != agent && -1 != agent.indexOf("Edge")) {// ie浏览器及Edge浏览器
                String name = java.net.URLEncoder.encode(fileNames, "UTF-8");
                codedFilename = name;
            } else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,Chrome等浏览器
                codedFilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedFilename ;
    }
}
