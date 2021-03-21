package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    private static Integer count=0;
    private  static volatile  Integer vcount=0;

    public static void main(String[] args) {
        //test1();//非volatile 多线程赋值安全性问题
        test2();//volatile 多线程赋值安全性问题
    }
    public static void test1(){
        Thread t1=new Thread(()->{
            for (int i=0;i<=100;i++) {
                count = 1;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + count);
            }
        },"T1: ");



        Thread t2=new Thread(()->{
            for (int i=0;i<=100;i++) {
                count = 2;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + count);
            }
        },"T2: ");


        t1.start();
        t2.start();
    }


    @Test
    public static void test2(){
        Thread t1=new Thread(()->{
            for (int i=0;i<=100;i++) {
                vcount = 1;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + vcount);
            }
        },"T1: ");



        Thread t2=new Thread(()->{
            for (int i=0;i<=100;i++) {
                vcount = 2;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + vcount);
            }
        },"T2: ");


        t1.start();
        t2.start();
    }
}
