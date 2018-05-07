package com.example.springconfigclient01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打开网址访问：http://localhost:8881/hi，网页显示：
 foo version 3
 这就说明，config-client从config-server获取了foo的属性，而config-server是从git仓库读取的,如图：
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class SpringConfigClient01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClient01Application.class, args);
	}

	@Value("${foo}")
	String foo;
	@Value("${democonfigclient.message}")
	String democonfigclient;
	/*@Value("${spring.rabbitmq.host}")
	String msg;*/
	@RequestMapping(value = "/hi")
	public String hi(){
		return foo+"|"+democonfigclient;
	}
	/*@RequestMapping(value = "/hi2")
	public String hi2(){
		return msg;
	}*/
}
