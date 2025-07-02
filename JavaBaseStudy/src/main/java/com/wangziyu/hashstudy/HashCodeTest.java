package com.wangziyu.hashstudy;

import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {
    public static void main(String[] args) {
        Person person1=new Person(1,"杨过");
        Person person2=new Person(1,"小龙女");
        System.out.println("Person1的hashCode:"+(person1.hashCode()+"  person2的hashCode:"+person2.hashCode()));
        System.out.println("Person1是否==Person2:"+(person1==person2));
        System.out.println("Person1是否equals于Person2:"+(person1.equals(person2)));

        Map<Person,String> map=new HashMap<>();
        map.put(person1,"person1");
        System.out.println("person1为键"+map.get(person1));
        System.out.println("person2为键"+map.get(person2));
    }
}
