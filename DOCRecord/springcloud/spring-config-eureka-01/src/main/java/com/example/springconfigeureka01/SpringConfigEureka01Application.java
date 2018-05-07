package com.example.springconfigeureka01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringConfigEureka01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigEureka01Application.class, args);
	}
}
