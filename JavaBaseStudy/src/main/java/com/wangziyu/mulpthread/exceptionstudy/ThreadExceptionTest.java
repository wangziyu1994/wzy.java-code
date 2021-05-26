package com.wangziyu.mulpthread.exceptionstudy;

import java.util.concurrent.TimeUnit;

public class ThreadExceptionTest {
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行.......");
            int i=12/0;
            System.out.println(Thread.currentThread().getName()+"异常后面代码.......");
        },"wzythread1");
        t1.setUncaughtExceptionHandler((t,e)->{
            Thread.UncaughtExceptionHandler un=Thread.currentThread().getUncaughtExceptionHandler();
            System.out.println("异常处理器是");
            System.out.println("线程未捕获的异常"+t.getName());
            System.out.println("线程未捕获的异常是");
            //e.printStackTrace();
            System.out.println("处理异常结束");

        });
        t1.start();
        TimeUnit.SECONDS.sleep(5);


    }
}
