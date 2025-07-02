package com.springsource.postconstrutorstudy;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;

public class PostConstructorTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("PostConstructorTest.xml");
		boolean flag=ClassUtils.isPresent("javax.annotation.Resource",AnnotationConfigUtils.class.getClassLoader());
		System.out.println(flag);
		Person person1 = applicationContext.getBean("person",Person.class);
		System.out.println("Person1 " + person1);
		applicationContext.close();
	}
}
