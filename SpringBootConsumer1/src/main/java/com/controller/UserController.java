package com.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wangziyu.Interfaces.ProviderInterface1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

/*	@Autowired
	HelloController h;*/

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProviderInterface1 providerInterface1;


	private String wzy;

	@Value("${wangziyu.name}")
	private String wangziyu;

/**
 * 测试eurka 微服务之间的调用
 */
	@RequestMapping(value="/use")
	public void useHello() {
		//System.out.println(MyVar.t);
		//String a=h.sayHello(uName);
		System.out.println("调用后");
	}

	/**
	 * 测试ribbon负载均衡
	 * @param uName
	 */
	@RequestMapping(value="/loadbanlanceRibbon")
	@HystrixCommand(fallbackMethod="myFallBackMethod")
	public void loadbanlance1(String uName) {
		System.out.println("负载均衡调用开始!");
		String a=restTemplate.getForEntity("http://SpringBootProvider/sayhello",String.class).getBody();
		System.out.println("负载均衡调用结束!返回"+a);
	}

	/**
	 * 测试ribbon feign负载均衡
	 * @param uName
	 */
	@RequestMapping(value="/loadbanlanceFeign",method = RequestMethod.POST)
	public String loadbanlance2() {
		System.out.println("Foreign负载均衡调用开始!");

		Map<String,String> m=new HashMap<String,String>();
		//m.put("msg",uName);

       String msg=providerInterface1.providerInterface1();
		System.out.println("Foreign负载均衡调用结束!返回");
		return msg;
	}


	public String myFallBackMethod(){
		System.out.println("调用外系统服务失败，开始执行断路器回调方法");
		return  "断路器回调方法";
	}

	/**
	 * 测试 从springconfig获取  配置文件
	 * @return
	 */
	@RequestMapping(value="/testspringcloudconfig",method = RequestMethod.GET)
	public String testSpringConfig(){
System.out.println("从springcloudconfig获取的值为"+wangziyu);
		return wangziyu;
	}
}
