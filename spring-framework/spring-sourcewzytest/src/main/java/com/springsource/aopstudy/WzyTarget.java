package com.springsource.aopstudy;

public class WzyTarget {
	private String name;



	public void wzytargetMethod(){
		System.out.println("进入WzyTargetMethod方法");
		//doException("targetMethodException");
		System.out.println("完成WzyTargetMethod方法");
	}
	public void doException(String name){
		throw new ArithmeticException(name);
	}
}
