package com.springsource.cycledependcy;

public class B {
	private  A a;

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}


	public void targetMethod(){
		System.out.println("B的targetMethod");
	}
}
