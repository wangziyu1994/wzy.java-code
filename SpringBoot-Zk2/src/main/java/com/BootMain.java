package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient//开启zookeeper注册服务中心
@EnableFeignClients
public class BootMain {



    public static void main(String args[]){

        SpringApplication.run(BootMain.class, args);

    }
}
