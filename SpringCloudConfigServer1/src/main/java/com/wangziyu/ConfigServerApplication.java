package com.wangziyu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer//开启springcloudcconfig-server的注解
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerApplication {

public static void main(String args[]){
    SpringApplication.run(ConfigServerApplication.class);
}



}
