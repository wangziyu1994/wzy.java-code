package com.springsource.test;

import com.springsource.model.MyClassPathApplicationContext;
import org.springframework.context.ApplicationContext;

public class MyClassPathApplicationContextTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new MyClassPathApplicationContext("Beans.xml");
	}
}
