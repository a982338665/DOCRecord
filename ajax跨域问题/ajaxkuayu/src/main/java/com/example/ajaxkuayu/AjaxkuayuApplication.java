package com.example.ajaxkuayu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AjaxkuayuApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxkuayuApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean registerFilter(){
//		FilterRegistrationBean bean=new FilterRegistrationBean();
//		bean.addUrlPatterns("/*");
//		bean.setFilter(new CrosFilter()) ;
//		return bean ;
//	}

}
