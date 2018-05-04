package com.example.springfeign01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 在它的pom文件引入Feign的起步依赖spring-cloud-starter-feign、Eureka的
 * 起步依赖spring-cloud-starter-eureka、Web的起步依赖spring-boot-starter-web
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringFeign01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeign01Application.class, args);
	}
}
