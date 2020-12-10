package com.mulpthread;

import org.junit.jupiter.api.Test;

public class ThreadTest {
    public static  int num=30;
    @Test
    public void test1(){

        Thread myThread1=new Thread(new MyThread1());
        Thread myThread2=new Thread(new MyThread1());
        Thread myThread3=new Thread(new MyThread1());
        Thread myThread4=new Thread(new MyThread1());
        Thread myThread5=new Thread(new MyThread1());
        Thread myThread6=new Thread(new MyThread1());
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
        myThread6.start();
    }
}
