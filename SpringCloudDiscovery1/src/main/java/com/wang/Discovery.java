package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//Eureka 注册服务中心标志注解
@SpringBootApplication
public class Discovery {

	public static void main(String args[]) {
		SpringApplication.run(Discovery.class, args);
	}
}
