package com.wangziyu.collectionstudy;

//import org.junit.jupiter.api.Test;

import org.junit.Test;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>();
        words.add(null);
        long totalTime = 0;
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }

            Iterator<String> iter = words.iterator();
            for (int i = 1; i <= 20 && iter.hasNext(); i++) {
                System.out.println(iter.next());
                System.out.println("...");
                System.out.println(words.size() + "distinct words:" + totalTime + "millSeconds");
            }
        }
    }

    //@Test
    public void test1() {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }

            Iterator<String> iter = words.iterator();
            for (int i = 1; i <= 20 && iter.hasNext(); i++) {
                System.out.println(iter.next());
                System.out.println("...");
                System.out.println(words.size() + "distinct words:" + totalTime + "millSeconds");
            }
        }
    }


    @Test
    public void test2() {
       Set<String> set=new TreeSet<>();
       byte b=1;
       long l=b;
       String [] str={};
       int a1=3;
       int b1=4;
       a1=a1+b1;
       b1=a1-b1;
       a1=a1-b1;
       System.out.println(a1);
       System.out.println(b1);
    }
}
