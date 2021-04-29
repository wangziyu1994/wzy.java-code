package com.springsource.applypropertyvalue;

import com.springsource.autowiredproperty.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplyPropertyValueTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplyPropertyTest.xml");
	}
}
