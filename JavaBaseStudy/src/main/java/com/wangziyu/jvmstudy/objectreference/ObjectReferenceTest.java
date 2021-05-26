package com.wangziyu.jvmstudy.objectreference;

import java.util.WeakHashMap;

public class ObjectReferenceTest {
    public static void main(String[] args) {
        WeakHashMap  weakHashMap=new WeakHashMap();

        Object o=new Object();
        Object[] arr=new Object[2];
        arr[0]=o;
        System.out.println(arr[0]);
        arr[0]=null;
        System.out.println(arr[0]);
        System.out.println(o);
    }
}
