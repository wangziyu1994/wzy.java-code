package com.springsource.test;

import com.springsource.model.Person;
import com.springsource.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSourceTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
		//Student student=(Student)applicationContext.getBean("student");
		//System.out.println(student);
	}

}
