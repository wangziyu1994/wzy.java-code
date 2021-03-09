package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    /**
     * SmaphoreTest主要设置限流
     * acquire 和release方法中的为limit的线程数量
     */
    @Test
    public void test1(){
        Semaphore semaphore=new Semaphore(5); //2限制线程数  true是公平锁
        for(int i=0;i<=19;i++){
            Thread thread=new Thread(()->{
              //  System.out.println(Thread.currentThread().getName()+"运行");
                try {
                   // System.out.println(Thread.currentThread().getName()+"等待...");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"运行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"通过...");

                }
            },"T"+i);
            thread.start();
        }

    }
}
