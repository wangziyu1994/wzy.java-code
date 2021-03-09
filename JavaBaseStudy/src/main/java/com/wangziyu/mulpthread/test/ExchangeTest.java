package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;

public class ExchangeTest {
    private Exchanger<String> exchanger=new Exchanger();

    @Test
    public void test1() {
       new Thread(() -> {
        String s="T0";
            try {
                s=exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"交换后变量:"+s);
        },"T0").start();

      new Thread(() -> {
            String s="T1";
            try {
               s= exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"交换后变量:"+s);
        },"T1").start();

    }
}
