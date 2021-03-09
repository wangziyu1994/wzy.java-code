package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private int size=10;

    //第一种写法
    private CyclicBarrier cyclicBarrier=new CyclicBarrier(size);

    //第二种写法
    private CyclicBarrier secondCyclic=new CyclicBarrier(size,new Thread(()->{
        System.out.println("我是线程" + Thread.currentThread().getName() + "到達"+size);
    }));

    @Test
    public void test1() throws BrokenBarrierException, InterruptedException {

        for(int i=0;i<=size-1;i++){
            Thread t=new Thread(()->{
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

        System.out.println("主线程等待....");

    }


    @Test
    public void test2() throws BrokenBarrierException, InterruptedException {
for(int i=0;i<=size+50;i++) {
    Thread t=new Thread(()->{
        System.out.println("我是线程" + Thread.currentThread().getName() + "开始运行");
        try {
            secondCyclic.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    });
    t.start();


}
    }
}
