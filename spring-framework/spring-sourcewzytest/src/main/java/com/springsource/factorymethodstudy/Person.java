package com.springsource.factorymethodstudy;

public class Person {
	private int id;
	private String name;

	public Person() {

	}
	public Person(int id) {
		System.out.println("调用一个参数的创建方法");
		this.id = id;
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(int id, String name) {
		System.out.println("调用两个参数的创建方法");
		this.id = id;
		this.name = name;
	}


}
