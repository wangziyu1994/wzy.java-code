package com.springsource.constructorresolver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorResolveTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ConstructorResolveTest.xml");
		Person person1=(Person)applicationContext.getBean("person1");
		Person person2=(Person)applicationContext.getBean("person2");
		System.out.println("Person1 "+person1+"  "+person1.getId());
		System.out.println("Person2 "+person2+"  "+person2.getId());
	}
}
