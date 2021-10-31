package com.wangziyu.collectionstudy;

import com.wangziyu.collectionstudy.model.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap map=new HashMap();

        map.put(1,"element1");
       // map.put(1,"element1");
        map.put(10,"element1");
        map.put(11,"element1");
        map.put(12,"element2");
        Iterator iterator=map.entrySet().iterator();  //modcount 4  expectedM 4
        Iterator iterator1=map.entrySet().iterator(); //modcount 4  expectedM 4
        Thread thread1=new Thread(()->{
            while(iterator.hasNext()){
                Map.Entry entryO=(Map.Entry) iterator.next();//modcount 5  == expectedM 5
                Integer key=(Integer) entryO.getKey();
                if(key==10){
                    iterator.remove(); //modcount 5  expectedM 5
                }
            }
        });

        thread1.start();

        while(iterator1.hasNext()){
            Map.Entry entry=(Map.Entry)iterator1.next();//modcount 5  expectedM 4
         System.out.println(entry.getKey()+"  "+entry.getValue());
        }

       // System.out.println(map.get(null));
    }
}
