package com.springsource.factorymethodstudy;

public class WzyStaticBeanFactory {
	public static Person createPerson(int args1,String args2){
		return new Person(args1,args2);
	}


	public static Person createPerson(int args1){
		return new Person(args1);
	}
}
