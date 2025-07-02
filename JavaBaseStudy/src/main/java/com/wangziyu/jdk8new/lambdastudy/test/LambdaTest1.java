package com.wangziyu.jdk8new.lambdastudy.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaTest1 {
    public static void main(String[] args) {
        BiFunction<String,String,Integer> comp=(String first,String second)-> {
         return    first.length() - second.length();
        };

        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add(null);
        list.add(null);
        list.add("5");
        for(String str:list){
            System.out.println(str);
        }

       /* list.removeIf((String e)->{
            return  e==null;
        });*/

        list.removeIf(e->
              e==null);

        for(String str:list){
            System.out.println(str);
        }
    }
}
