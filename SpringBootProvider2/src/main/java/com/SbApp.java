
package com;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableEurekaClient
@EnableAspectJAutoProxy
//@SpringBootConfiguration    //自动配置注解代替 configuration
//@Configuration
public class SbApp {

	private static Logger logger = LoggerFactory.getLogger("SbApp.class");
public static void main(String args[]) {
	logger.debug("SbApp-DEBUG方法");
	SpringApplication.run(SbApp.class,args);

}
}
