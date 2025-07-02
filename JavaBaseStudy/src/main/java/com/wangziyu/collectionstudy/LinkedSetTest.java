package com.wangziyu.collectionstudy;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LinkedSetTest {
    public static void main(String[] args) {
        LinkedHashSet linkedSet=new LinkedHashSet();
        linkedSet.add("你好");
        linkedSet.add("a你好");
        linkedSet.add("z你好");
        linkedSet.add("b你好");
        linkedSet.add("e你好");

        LinkedHashMap linkedHashMap=new LinkedHashMap();
        linkedSet.forEach((k)->{
            System.out.println(k);
            linkedHashMap.put(k,k);
        });

        linkedHashMap.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
}
