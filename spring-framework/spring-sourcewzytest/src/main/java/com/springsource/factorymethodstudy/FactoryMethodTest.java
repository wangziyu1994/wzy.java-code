package com.springsource.factorymethodstudy;

import com.springsource.factorymethodstudy.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMethodTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("FactoryMethodTest.xml");
		Person person1=(Person) applicationContext.getBean("staticFactory-person1");
		Person person1copy=(Person) applicationContext.getBean("staticFactory-person1");

		Person person2=(Person) applicationContext.getBean("instanceFactory-person1");
		Person person2copy=(Person) applicationContext.getBean("instanceFactory-person1");

		Person person3=(Person) applicationContext.getBean("staticFactory-person2");
		Person person3copy=(Person) applicationContext.getBean("staticFactory-person2");

		Person person4=(Person) applicationContext.getBean("instanceFactory-person2");
		Person person4copy=(Person) applicationContext.getBean("instanceFactory-person2");

		System.out.println("static工厂创建的Bean1:"+person1+"  "+person1.hashCode());//44a7bfbc  1151844284
		System.out.println("static工厂创建的Bean1copy:"+person1copy+"  "+person1copy.hashCode());
		System.out.println("instance工厂创建的Bean1:"+person2+"  "+person2.hashCode());
		System.out.println("instance工厂创建的Bean1copy:"+person2copy+"  "+person2copy.hashCode());
		System.out.println("static工厂创建的Bean2:"+person3+"  "+person3.hashCode());
		System.out.println("static工厂创建的Bean2copy:"+person3copy+"  "+person3copy.hashCode());
		System.out.println("instance工厂创建的Bean2:"+person4+"  "+person4.hashCode());
		System.out.println("instance工厂创建的Bean2copy:"+person4copy+"  "+person4copy.hashCode());

	}
}
