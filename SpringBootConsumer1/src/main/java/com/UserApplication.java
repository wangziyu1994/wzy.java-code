package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix//开启断路器功能
@EnableHystrixDashboard//开启断路器监控
public class UserApplication {

	
	public static void main(String args[]) {
		SpringApplication.run(UserApplication.class, args);
		
		
	}
}
