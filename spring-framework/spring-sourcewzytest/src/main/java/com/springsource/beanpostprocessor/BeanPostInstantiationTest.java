package com.springsource.beanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostInstantiationTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("BeanPostInstantationTest.xml");
		Person person1=(Person)applicationContext.getBean("personPost");
		Person person2=applicationContext.getBean(Person.class);
		System.out.println("Person1 "+person1+"  "+person1.getName());
		System.out.println("Person2 "+person2+"  "+person2.getName());
	}
}
