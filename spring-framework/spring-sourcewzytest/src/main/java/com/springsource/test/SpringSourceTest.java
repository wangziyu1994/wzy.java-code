package com.springsource.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSourceTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("customNameSpace.xml");
		//Student student=(Student)applicationContext.getBean("student");
		//System.out.println(student);
	}


}
