package com.springsource.autowiredproperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredPropertyTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AutoWiredPropertyTest.xml");
		//Animal animal= applicationContext.getBean(Animal.class);
		Book book=applicationContext.getBean(Book.class);
		System.out.println(book);
	}
}
