
package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


//@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableEurekaClient
//@SpringBootConfiguration    //自动配置注解代替 configuration
//@ComponentScan
//@Configuration
public class SbApp {
	

public static void main(String args[]) {
	SpringApplication.run(SbApp.class,args);
}
}
