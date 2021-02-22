package com.wzytest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {
	public void XmlReadTest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("");
		//applicationContext.ge
	}

	public void AnnotationReadTest(){
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext("");
		//applicationContext.getB
	}
}
