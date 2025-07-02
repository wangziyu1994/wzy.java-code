package com.springsource.test;

import com.springsource.custom.WzyAttrJavaBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCustomNameSpaceTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("customNameSpace.xml");
		WzyAttrJavaBean wzyAttrJavaBean=applicationContext.getBean(WzyAttrJavaBean.class);
		System.out.println(wzyAttrJavaBean);
	}
}
