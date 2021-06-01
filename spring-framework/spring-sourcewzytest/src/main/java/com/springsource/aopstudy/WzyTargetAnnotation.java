package com.springsource.aopstudy;

import org.springframework.stereotype.Component;

@Component
public class WzyTargetAnnotation {
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
