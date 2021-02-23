package com.springsource.test;

import com.springsource.model.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSourceTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
		Person person=(Person)applicationContext.getBean("wangziyu");
		System.out.println("您好");
		System.out.println(person);
	}

}
