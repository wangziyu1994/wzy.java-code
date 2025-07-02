package com.springsource.factorymethodstudy;

public class WzyInstanceBeanFactory {

	public  Person createPerson(int args1,String args2){
		return new Person(args1,args2);
	}

	public  Person createPerson(int args1){
		return new Person(args1);
	}
}
