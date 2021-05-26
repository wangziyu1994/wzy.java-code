package com.wangziyu.collectionstudy;

import com.wangziyu.collectionstudy.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put(1,"element1");
        map.put(1,"element1");
        map.put(10,"element1");
        map.put(null,"element1");
        map.put(null,"element2");

        System.out.println(map.get(null));
    }
}
