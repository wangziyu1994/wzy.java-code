package com.springsource.autowiredpostprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person extends ParentClass{
	private int id;
	@Value(value="wangziyu")
	private String name;
	@Autowired
	private Car car;



	public Person() {
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Autowired
	public void autowirdMethod(){
		System.out.println("我是被@Autowired注解修饰的方法");
	}

	@Value(value="valuemethod")
	public void valueMethod(){
		System.out.println("我是被@value注解修饰的方法");
	}
}
