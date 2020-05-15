package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class UserController {

/*	@Autowired
	HelloController h;*/

	@Autowired
	private RestTemplate restTemplate;

/**
 * 测试eurka 微服务之间的调用
 */
	@RequestMapping(value="/use")
	public void useHello(String uName) {
		System.out.println("调用前"+uName);
		//String a=h.sayHello(uName);
		System.out.println("调用后");
	}

	/**
	 * 测试ribbon负载均衡
	 * @param uName
	 */
	@RequestMapping(value="/loadbanlance")
	public void loadbanlance(String uName) {
		System.out.println("负载均衡调用开始!");
		String a=restTemplate.getForEntity("http://SpringBootProvider/sayhello",String.class).getBody();
		System.out.println("负载均衡调用结束!返回"+a);
	}
}
