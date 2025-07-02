package com.wangziyu.mulpthread.test;

import com.wangziyu.mulpthread.model.MyThread2;
import org.junit.jupiter.api.Test;

public class CasLockTest {

    @Test
    public void test(){
        int i=0;
        Thread thread1=new Thread(new MyThread2(),++i+"");
        Thread thread2=new Thread(new MyThread2(),++i+"");
        Thread thread3=new Thread(new MyThread2(),++i+"");
        Thread thread4=new Thread(new MyThread2(),++i+"");
        Thread thread5=new Thread(new MyThread2(),++i+"");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }
}
