package com.wangziyu.jdk8new.lambdastudy.test;

import com.wangziyu.jdk8new.lambdastudy.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FunctionTest {

    Consumer<Person> consumer1;
    Consumer<Person> consumer2;
    List<Person> list=new ArrayList<>();
    List<Person> list1=new LinkedList<>();
    @Before
    public void prepare(){
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        consumer1=(e)->{
            System.out.println("接收"+e.getAge());
            e.setAge(10);
            System.out.println("修改后:"+e.getAge());
        };

        consumer2=(e)->{
            System.out.println("接收"+e.getAge());
            e.setAge(20);
            System.out.println("修改后:"+e.getAge());
        };
    }

    @Test
    public void test1(){
        list.forEach(consumer1.andThen(consumer2));
        list.forEach((e)->{
            System.out.println(e.getAge());
        });
      /*  List list1=new ArrayList<>();
        list1.forEach(consumer1);*/
    }
}
