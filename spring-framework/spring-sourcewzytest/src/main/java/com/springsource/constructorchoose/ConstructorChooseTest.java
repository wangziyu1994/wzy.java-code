package com.springsource.constructorchoose;

import com.springsource.constructorresolver.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorChooseTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ConstructorChooseTest.xml");
		com.springsource.constructorresolver.Person person1=(Person)applicationContext.getBean("person1");
	}
}
