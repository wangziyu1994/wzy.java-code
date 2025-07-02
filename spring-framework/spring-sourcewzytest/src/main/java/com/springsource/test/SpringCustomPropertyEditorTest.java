package com.springsource.test;

import com.springsource.custom.WzyAttrJavaBean;
import com.springsource.custom.WzyPerson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCustomPropertyEditorTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("propertyEditorTest.xml");
		WzyPerson wzyPerson=applicationContext.getBean(WzyPerson.class);
		System.out.println(wzyPerson);
	}
}
