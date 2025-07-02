package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountLatchTest {
    int size=10;
    @Test
    public void test1() throws InterruptedException {
        List<Thread> arrayList=new ArrayList();

        CountDownLatch countDownLatch=new CountDownLatch(size);
        for(int i=0;i<=size-1;i++) {
            Thread t = new Thread(() -> {
                System.out.println("我是线程" + Thread.currentThread().getName() + "开始运行");
                countDownLatch.countDown();
            });
            arrayList.add(t);
        }
        for(Thread element:arrayList){
            element.start();
        }
        System.out.println("主线程等待await");
        countDownLatch.await();
        System.out.println("主线程完成");
    }

@Test
    public void test2() throws InterruptedException {
        List<Thread> arrayList=new ArrayList();

        CountDownLatch countDownLatch=new CountDownLatch(size);
        for(int i=0;i<=size-1;i++) {
            Thread t = new Thread(() -> {
                System.out.println("我是线程" + Thread.currentThread().getName() + "开始运行");
                countDownLatch.countDown();
            });
            arrayList.add(t);
        }
        for(Thread element:arrayList){
            element.start();
        }
       // Thread.sleep(6000);
        System.out.println("主线程等待await");
        countDownLatch.await(10000, TimeUnit.MILLISECONDS);
        System.out.println("主线程完成");
    }
}
