package com.controller;

import java.util.List;

import com.dao.HelloDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.HelloDao;
import com.model.HelloUser;

@RestController

public class HelloController implements HelloInter{
	private static Logger logger=LoggerFactory.getLogger("HelloController.class");
	@Autowired
	private  HelloDao hd;

	@Value("${server.port}")
	private String port;

	@Value("${server.port1}")
	private String port1;

	@Value("${server.port2}")
	private String port2;

	@Autowired
	HelloDaoImpl helloDao;
	
	@RequestMapping(value="/sayhello")
	  
 public String sayHello(String uName) {
		System.out.println("进入springbootProvider1提供的服务"+port1);
		System.out.println("进入springbootProvider1提供的服务"+port2);
		/*
		 * try { int i=9/0; } catch(ArithmeticException ae) { logger.error("日志记录算术异常");
		 * } int i=0; while(i<200) { logger.trace("trace日志记录开始");
		 * logger.debug("debug日志记录开始"); logger.info("info日志记录开始");
		 * logger.warn("warn日志记录开始"); logger.error("error日志记录开始"); i++; }
		 */
		//List<HelloUser>  lh=hd.selectHello();
		return "springbootProvider1:"+port;
		}
	
	@RequestMapping(value="/sayhello1")
	  
 public String sayHello1(String uName) { 
		
		/*
		 * try { int i=9/0; } catch(ArithmeticException ae) { logger.error("日志记录算术异常");
		 * } int i=0; while(i<200) { logger.trace("trace日志记录开始");
		 * logger.debug("debug日志记录开始"); logger.info("info日志记录开始");
		 * logger.warn("warn日志记录开始"); logger.error("error日志记录开始"); i++; }
		 */
		List<HelloUser>  lh=hd.selectHello1();
		return lh.get(0).getUserName()+"   "+lh.get(1).getUserName(); 
		}
	@RequestMapping(value="/test")

	public String test( ) {

	System.out.println("===============登录成功================");

		List<HelloUser> lists=helloDao.selectHello();

		for(HelloUser h:lists){
			logger.info("当前时间点是"+System.currentTimeMillis());
			logger.info("数据库时间点是"+h.getStartDate());
			if(h.getStartDate()!=null) {
				Long a = h.getStartDate().getTime();
				h.getStartDate();
			}

		}

		return "登录成功!!";
	}
	 
}
