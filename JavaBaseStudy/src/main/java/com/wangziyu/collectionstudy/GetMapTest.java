package com.wangziyu.collectionstudy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GetMapTest {
    static Map<String,String> targetMap=new HashMap<>();
    static{
        targetMap.put("1","first");
        targetMap.put("2","second");
        targetMap.put("3","third");
        targetMap.put("4","four");
        targetMap.put("5","five");
        targetMap.put("6","six");
    }

    public static void main(String[] args) {
        iteratorMethod(targetMap);
        entrySetMethod(targetMap);
        keySetMethod(targetMap);
    }

    public static void  iteratorMethod(Map<String,String> targetMap){
        Iterator<String> iterator=targetMap.keySet().iterator();
        while(iterator.hasNext()){
            String key=iterator.next();
            System.out.println(key+":"+targetMap.get(key));
        }
    }

    public static void  entrySetMethod(Map<String,String> targetMap){
      Set<Map.Entry<String,String>>  entrySets=targetMap.entrySet();
      for(Map.Entry entry:entrySets){
          System.out.println(entry.getKey()+":"+entry.getValue());
      }
    }


    public static void  keySetMethod(Map<String,String> targetMap){
        Set<String>  keySet=targetMap.keySet();
        for(String key:keySet){
            System.out.println(key+":"+targetMap.get(key));
        }
    }
}
