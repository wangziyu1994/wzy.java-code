package com.springsource.resourceannotation;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Resource
public class Person {
	private int id;
	@Resource
	private String name;

	public Person() {
	}

	public Person(int id) {
		this.id = id;
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Resource
	public void resourceMethod(String name){
		System.out.println("我是被注解@Resource修饰的方法");
	}
}
