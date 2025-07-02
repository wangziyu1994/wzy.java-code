package com.springsource.resourceannotation;

import com.springsource.constructorresolver.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceAnntationTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("FindResourceTest.xml");
		Person person1=(Person)applicationContext.getBean("person1");
	}
}
