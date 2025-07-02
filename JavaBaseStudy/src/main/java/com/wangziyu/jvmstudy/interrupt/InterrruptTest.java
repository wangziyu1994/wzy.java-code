package com.wangziyu.jvmstudy.interrupt;

import java.util.concurrent.TimeUnit;

public class InterrruptTest {
    public static void main(String[] args) throws InterruptedException {
        boolean flag=true;
        Thread t1=new Thread(()->{
           /* try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //Thread.interrupted();
           System.out.println("t1开始run");
            System.out.println("t1中断标识"+Thread.currentThread().isInterrupted());
            boolean first=Thread.interrupted();
            System.out.println("t1中断标识"+Thread.currentThread().isInterrupted()+" "+first);
            boolean second=Thread.interrupted();
            System.out.println("t1中断标识"+Thread.currentThread().isInterrupted()+" "+second);
          /* while (flag){

           }*/
        },"T1");

        t1.start();
        t1.interrupt();
        TimeUnit.SECONDS.sleep(5);

    }
}
