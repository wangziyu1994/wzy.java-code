package com.springsource.autowiredproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Animal {
	private int id;
	private String name;
	@Autowired
	private AaFood aAFood1;

	private Address anaddress;


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



	@Autowired
	public void initAddress(Address anaddress){
		System.out.println("执行address方法");
		this.anaddress=anaddress;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"id=" + id +
				", name='" + name + '\'' +
				", aAFood1=" + aAFood1 +
				", anaddress=" + anaddress +
				'}';
	}
}
