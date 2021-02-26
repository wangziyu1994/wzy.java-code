package com.wzytest;

import com.springsource.model.Person;
import com.springsource.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	@Test
	public void XmlReadtest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
		Person person=(Person)applicationContext.getBean("person");
		System.out.println(person);

	}
	@Test
	public void AnnotationReadtest(){
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Person.class);
		Person person=(Person)applicationContext.getBean("person");
		System.out.println(person);

	}

	/**
	 * 测试spring Bean的循环依赖问题
	 */
	@Test
	public void cycalDependcytest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
		Student student=(Student)applicationContext.getBean("student");
		System.out.println(student);

	}
}
