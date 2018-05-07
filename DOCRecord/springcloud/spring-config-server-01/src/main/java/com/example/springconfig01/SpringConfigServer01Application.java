package com.example.springconfig01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//在程序的入口Application类加上@EnableConfigServer注解开启配置服务器的功能，代码如下：
@EnableConfigServer
@SpringBootApplication
//服务注册--高可用配置中心
@EnableEurekaClient
public class SpringConfigServer01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServer01Application.class, args);
	}
}
