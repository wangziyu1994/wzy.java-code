package com.wangziyu.mulpthread.test;

import com.wangziyu.mulpthread.model.CommonObject;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class TheadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }
    @Test
    public static void test1() throws InterruptedException {
         ThreadLocal<CommonObject> threadLocal=new ThreadLocal<>();
        new Thread(()->{
          //threadLocal.set(new CommonObject("commonObject1",1));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+threadLocal.get());
        },"T1").start();


        new Thread(()->{
            threadLocal.set(new CommonObject("commonObject2",2));
            System.out.println(Thread.currentThread().getName()+threadLocal.get());
        },"T2").start();

            TimeUnit.SECONDS.sleep(10);
            threadLocal.remove();
    }

}
