package com.springsource.factorybeanstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("FactoryBeanTest.xml");
		Person person=(Person) applicationContext.getBean("personFactoryBean");
		WzyFactoryBean wzyFactoryBean=(WzyFactoryBean) applicationContext.getBean("&personFactoryBean");
		System.out.println(person);
		System.out.println(wzyFactoryBean);
	}
}
