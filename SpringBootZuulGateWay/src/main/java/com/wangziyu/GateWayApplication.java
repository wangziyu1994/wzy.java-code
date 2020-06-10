package com.wangziyu;


import com.wangziyu.gateway.WzyGateWay1;
import com.wangziyu.gateway.WzyGateWay2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
//@EnableEurekaClient
public class GateWayApplication {



    public static void main(String args[]){

        SpringApplication.run(GateWayApplication.class);

    }

    @Bean
    public WzyGateWay1 getWzyGateway1(){
        return new WzyGateWay1();
    }
    @Bean
    public WzyGateWay2 getWzyGateway2(){
        return new WzyGateWay2();
    }
}
