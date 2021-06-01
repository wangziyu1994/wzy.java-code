package com.springsource.cycledependcy;

public class A {
	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public void targetMethod(){
    System.out.println("A的targetMethod");
	}
}
