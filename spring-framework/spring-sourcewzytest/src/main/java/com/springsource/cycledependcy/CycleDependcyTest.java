package com.springsource.cycledependcy;

import com.springsource.beanpostprocessor.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class CycleDependcyTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("CycleDependcyTest.xml");
		A a=applicationContext.getBean(A.class);
		B b=applicationContext.getBean(B.class);
		a.targetMethod();
		b.targetMethod();

	}
}
