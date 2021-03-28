package com.springsource.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadAnnotationTest {
	public static void main(String[] args) {
		loadConfguration();
	}

	public static void loadConfguration(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ConfigurationAnntationBeans.xml");
	}

	public static void loadPropertySource(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ConfigurationAnntationBeans.xml");
	}
}
