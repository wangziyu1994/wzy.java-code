package com.springsource.aopstudy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.Properties;

public class AopStudyAnnotationTest {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(WzyLogAopAnnotation.class);
		applicationContext.refresh();
		WzyTarget a=applicationContext.getBean(WzyTarget.class);
		a.wzytargetMethod();
	}



}
