package com.springsource.cycledependcy;

public class ProxyClass {

	public void targetMethod(){

	}

	public void before(){
		System.out.println("我是代理对象的before方法");
	}
}
