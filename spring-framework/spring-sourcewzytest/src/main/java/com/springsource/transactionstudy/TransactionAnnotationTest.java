package com.springsource.transactionstudy;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;

public class TransactionAnnotationTest {
	public static void main(String[] args) {
			AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
			applicationContext.register(WzyTargetAnnotation.class,WzyTransactionAopAnnotation.class,TestConfiguration1.class,TestConfiguration2.class);
			applicationContext.refresh();
		WzyTransactionAopAnnotation a=applicationContext.getBean(WzyTransactionAopAnnotation.class);
		ProxyTransactionManagementConfiguration pcp=applicationContext.getBean(ProxyTransactionManagementConfiguration.class);
		TestConfiguration1 tc1=applicationContext.getBean(TestConfiguration1.class);
		TestConfiguration2 tc2=applicationContext.getBean(TestConfiguration2.class);
		System.out.println(a.getClass().getName());
		System.out.println(pcp.getClass().getName());
		System.out.println(tc1.getClass().getName());
		System.out.println(tc2.getClass().getName());
		}
}
