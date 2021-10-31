package com.wangziyu.mulpthread.test;


import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    private Lock commonLocak = new ReentrantLock();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();
    public static  int value;

@Test
    public void test1() throws InterruptedException {
        Runnable readRun = () -> {
            try {
                read(readLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable writeRun = () -> {
            try {
                write(writeLock,new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 18; i++) new Thread(readRun).start();
        for (int i = 0; i < 5; i++) new Thread(writeRun).start();
        Thread.sleep(20000);

    }

    public static void read(Lock lock) throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"读。。。。");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"读完成");
        lock.unlock();
    }


    public static void write(Lock lock,int v) throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"写....");
        Thread.sleep(1000);
        value = v;
        System.out.println(Thread.currentThread().getName()+"写完成");
        lock.unlock();
    }


}
