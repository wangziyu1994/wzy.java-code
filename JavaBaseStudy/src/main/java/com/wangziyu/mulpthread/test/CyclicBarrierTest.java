package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private int size = 10;

    //第一种写法
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(size);

    //第二种写法
    private CyclicBarrier secondCyclic = new CyclicBarrier(size, new Thread(() -> {
        System.out.println("我是线程" + Thread.currentThread().getName() + "到达cyclic栅栏数量" + size);
    },"monitor"));

    @Test
    public void test1() throws BrokenBarrierException, InterruptedException {

        for (int i = 0; i <= size - 1; i++) {
            Thread t = new Thread(() -> {
                System.out.println("我是线程" + Thread.currentThread().getName() + "已到达栅栏");
                try {
                    cyclicBarrier.await();
                    System.out.println("我是线程" + Thread.currentThread().getName() + "已通过栅栏");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            });
            t.start();
        }

        System.out.println(Thread.currentThread().getName()+"主线程等待....");

    }


    @Test
    public void test2() throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i <= 2*size - 1; i++) {
            Thread t = new Thread(() -> {
                System.out.println("我是线程" + Thread.currentThread().getName() + "已到达栅栏");
                try {
                    secondCyclic.await();
                    System.out.println("我是线程" + Thread.currentThread().getName() + "已通过栅栏");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i));
            t.start();


        }
    }
}
