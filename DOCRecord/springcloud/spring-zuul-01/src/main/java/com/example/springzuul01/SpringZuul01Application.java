package com.example.springzuul01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 在其入口applicaton类加上注解@EnableZuulProxy，开启zuul的功能：
 */
@EnableZuulProxy
@SpringBootApplication
public class SpringZuul01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuul01Application.class, args);
	}
}
