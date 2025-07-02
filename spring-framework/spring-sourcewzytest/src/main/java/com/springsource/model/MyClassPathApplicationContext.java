package com.springsource.model;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathApplicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathApplicationContext(String configLocation){
		super(configLocation);
	}

	public void initPropertySources() {
		//设置属性验证
		System.out.println("开始自定义属性拓展验证");
		getEnvironment().setRequiredProperties("username");
	}



	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		System.out.println("开始自定义设置工厂的属性");
	}
}
