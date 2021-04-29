package com.springsource.autowiredpostprocessor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredPostProcessorTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AutoWiredPostProcessorTest.xml");
	}
}
