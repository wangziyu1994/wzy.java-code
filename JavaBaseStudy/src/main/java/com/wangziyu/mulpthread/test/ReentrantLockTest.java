package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;


/**
 * 与synchronized区别
 * 相同 CAS，并且可以完全替换synchronized
 * 不同 可以trylock(,)直接设置线程的超时时间
 *      可以通过设置lockInterruptibly 再调用线程的interrupt打断
 *      reentrant (true:false)可以设置公平锁与不公平锁,但是synchronized只能是公平锁
 */
public class ReentrantLockTest {
   public static Integer count=0;

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

   @Test
    public static void test1() throws InterruptedException {

       ReentrantLock reentrantLock=new ReentrantLock(true);

        Thread t1=new Thread(()->{
            reentrantLock.lock();
            for(int i=0;i<=999;i++){
                count++;
            }
           System.out.println(Thread.currentThread().getName()+"结束了");
            reentrantLock.unlock();
        });
        Thread t2=new Thread(()->{
            reentrantLock.lock();
            for(int i=0;i<=999;i++){
                count++;
            }
            System.out.println(Thread.currentThread().getName()+"结束了");
            reentrantLock.unlock();
        });

        t1.start();
        t2.start();
        Thread.sleep(5000);
        System.out.println(count);





    }

    public void count(Integer count){

    }
}
