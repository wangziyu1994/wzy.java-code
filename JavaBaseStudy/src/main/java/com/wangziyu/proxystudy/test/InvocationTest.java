package com.wangziyu.proxystudy.test;

import com.wangziyu.proxystudy.model.TraceHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class InvocationTest {
    public static void main(String[] args) {
        Object[] elements=new Object[1000];
        for(int i=0;i<=elements.length-1;i++){
            Integer value=i+1;
            InvocationHandler handler=new TraceHandle(value);
            Object proxy= Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i]=proxy;
        }
        Integer key=new Random().nextInt(elements.length)+1;
        int result= Arrays.binarySearch(elements,key);
        if(result>=0)System.out.println(elements[result]);


    }
}
