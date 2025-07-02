package com.wangziyu.mulpthread;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 一个容器,两个线程，一个线程添加元素,另一个元素监控容器，当容器元素达到5时，打印一句话，然后停止.
 */
public class DoubleThreadListTest1 {
    private static List<Integer> targetList=new ArrayList();
    private static  List<Integer> synchronList= Collections.synchronizedList(targetList);
    private static volatile List<Integer> volatileSynchronList= Collections.synchronizedList(targetList);

    public static void main(String[] args) throws InterruptedException {
        //test1();//不同步方法实现。错误
       // test2();//LIST添加读取元素同步之后 错误
        test3();//不同步方法实现,LIST添加读取元素同步之后 。错误
    }
    /**
     * 不同步方法实现。错误
     */
    @Test
    public static  void test1(){
        Thread t1=new Thread(()->{
            for(int i=0;i<=9;i++){
            targetList.add(i);
            System.out.println(Thread.currentThread().getName()+targetList.get(i));
            }
        },"T1");


        Thread t2=new Thread(()->{
            while (true) {
                if (targetList.size() == 5) {
                    System.out.println(Thread.currentThread().getName()+"元素个数为5,线程2停止");
                    break;
                }
            }
        },"T2");


        t1.start();
        t2.start();
    }


    /**
     * LIST添加读取元素同步之后 错误
     */
    @Test
    public static void test2() throws InterruptedException {
       new Thread(()->{
            for(int i=0;i<=9;i++){
                synchronList.add(i);
                System.out.println("线程"+Thread.currentThread().getName()+"添加完元素"+synchronList.get(i));
            }
        },"T1").start();


        new Thread(()->{
            while (true) {
                if (synchronList.size() == 5) {
                    System.out.println("线程"+Thread.currentThread().getName()+"元素个数为5");
                    break;
                }
            }
        },"T2").start();


    }


    /**
     * 同步方法实现  只是保证每次一个线程添加线程。读取线程。并未保证可见性.
     * volatile化集合  错误  volatile修饰集合内存地址未发生改变
     */
    @Test
    public static void test3() throws InterruptedException {
        new Thread(()->{
            for(int i=0;i<=9;i++){
                volatileSynchronList.add(i);
                System.out.println("线程"+Thread.currentThread().getName()+"添加完元素"+volatileSynchronList.get(i));
            }
        },"T1").start();


        new Thread(()->{
            while (true) {
                if (volatileSynchronList.size() == 5) {
                    System.out.println("线程"+Thread.currentThread().getName()+"元素个数为5");
                    break;
                }
            }
        },"T2").start();


    }


}
