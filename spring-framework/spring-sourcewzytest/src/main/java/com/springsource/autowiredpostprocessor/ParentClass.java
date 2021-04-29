package com.springsource.autowiredpostprocessor;

import org.springframework.beans.factory.annotation.Autowired;

public class ParentClass {
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Autowired
	public void  parentAutoWiredMethod(){
		System.out.println("我是父类被@Autowired注解修饰的方法");
	}
}
