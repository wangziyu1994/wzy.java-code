package com.springsource.transactionstudy;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
	public static void main(String[] args) throws Exception {
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("TransactionTest.xml");
			WzyTarget a=applicationContext.getBean(WzyTarget.class);
			//a.wzytargetMethod1();
			a.wzytargetMethod2();
		}
}
