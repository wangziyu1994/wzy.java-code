package com.wangziyu.genericstudy;


import org.junit.jupiter.api.Test;

public class GenericTest {
    @Test
    public void test1(){
        Son son=new Son();
        son.setName("absdfdsafadsfsf");
        MyGenericClass myGenericClass=new MyGenericClass<>(son,100);
        System.out.println(myGenericClass.getB1());
        System.out.println(myGenericClass.getT1());
        String []str={"aaaa","1111111111","你好"};
        Integer []ints={1,2,3,4,5};
        String a=MyGenericMethod.<String>get(str);
        Integer b=MyGenericMethod.get(ints);
        System.out.println(a);
        System.out.println(b);
    }


    @Test
    public void test2(){
        int a=0;
        int c=0;
        int b=a--;
        int d=--c;
        System.out.println(a);//-1
        System.out.println(b);//0
        System.out.println(c);//-1
        System.out.println(d);//-1
    }
}
