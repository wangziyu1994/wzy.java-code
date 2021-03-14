package com;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
        Person wzy=(Person)applicationContext.getBean(Person.class);
        System.out.println(wzy);
    }
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml.xml");
    }
}
