package com.springsource.postconstrutorstudy;


import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class Person {
	public Person() {
		System.out.println("person 构造方法");
	}

	@PostConstruct
	public void initMethod(){

		System.out.println("进行initMethod方法");
	}

	@PreDestroy
	public void destroy(){

		System.out.println("进行destroyMethod方法");
	}



}
