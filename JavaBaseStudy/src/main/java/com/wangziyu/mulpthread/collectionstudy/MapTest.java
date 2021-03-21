package com.wangziyu.mulpthread.collectionstudy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;

public class MapTest {


    public static int ticketSize=1000000;
    public static int threadSize=100;
    public static int gap = ticketSize/threadSize;
    public static Map<String,String> hashMap = new HashMap<>();
    public static Map<String,String> hashTable = new Hashtable();
    public static Map<String,String> synchronizedMap  =Collections.synchronizedMap(hashMap);
    public static Map<String,String> concurrentMap = new ConcurrentHashMap<>();
    public static String[] keys=new String[ticketSize];
    public static String[] values=new String[ticketSize];

    static {
        for (int i = 0; i < ticketSize; i++) {
            keys[i]=UUID.randomUUID().toString();
            values[i]=UUID.randomUUID().toString();
        }
    }


    public static void main(String[] args) {
        LocalTime startTime= LocalTime.now();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(threadSize,new Thread(()->{
            LocalTime endTime=LocalTime.now();
            System.out.println("总共耗费"+ ChronoUnit.MILLIS.between(startTime,endTime)+"毫秒");
        }));
        hashMapTest(cyclicBarrier);//hashMap测试 158ms 线程不安全
       //hashTableTest(cyclicBarrier); //hashTable测试 164ms 线程安全
       // synChronizedMapTest(cyclicBarrier); // synchornMap测试 128ms 线程安全
       // conCurrentMapTest(cyclicBarrier);// conCurrentMap测试 130ms 线程安全


    }


    public static void hashMapTest(CyclicBarrier cyclicBarrier){
            for(int i=0;i<threadSize;i++) {
                int start=i;
                new Thread(() -> {
                    for (int j = start; j < ticketSize; j=j+gap) {
                        hashMap.put(keys[j], values[j]);
                        System.out.println(Thread.currentThread().getName()+"放入了"+j);
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                },"T"+i).start();
            }
        }


    public static void hashTableTest(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < threadSize; i++) {
            int start = i;
            new Thread(() -> {
                for (int j = start; j < ticketSize; j = j + gap) {
                    hashTable.put(keys[j], values[j]);
                    System.out.println(Thread.currentThread().getName() + "放入了" + j);
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "T" + i).start();
        }
    }


        public static void synChronizedMapTest (CyclicBarrier cyclicBarrier){
            for (int i = 0; i < threadSize; i++) {
                int start = i;
                new Thread(() -> {
                    for (int j = start; j < ticketSize; j = j + gap) {
                        synchronizedMap.put(keys[j], values[j]);
                        System.out.println(Thread.currentThread().getName() + "放入了" + j);
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }, "T" + i).start();
            }
        }


    public static void conCurrentMapTest (CyclicBarrier cyclicBarrier){
        for (int i = 0; i < threadSize; i++) {
            int start = i;
            new Thread(() -> {
                for (int j = start; j < ticketSize; j = j + gap) {
                    concurrentMap.put(keys[j], values[j]);
                    System.out.println(Thread.currentThread().getName() + "放入了" + j);
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "T" + i).start();
        }
    }
    }
