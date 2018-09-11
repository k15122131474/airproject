package com.sfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author David
 * @date 2017/12/01.
 * 后台启动类
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.sfa.dao")
@SpringBootApplication
@EnableWebMvc
@EnableSwagger2 
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
    @Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(1800);//单位为S
				container.setPort(8077);
			}
		};
	}
    
  
}

