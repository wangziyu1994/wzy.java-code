package com.springsource.suppliesstudy;

import com.springsource.suppliesstudy.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SupplierTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("SupplierTest.xml");
		Person person1=applicationContext.getBean(Person.class);
		Person person2=(Person) applicationContext.getBean("wzySupplierBean");
		System.out.println("supplier创建的Bean:"+person1+person1.hashCode());
		System.out.println("supplier创建的Bean:"+person2+person2.hashCode());
	}
}
