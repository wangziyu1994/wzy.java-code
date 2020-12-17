package com.wangziyu.mulpthread.model;


public class MyThread2 implements Runnable{

    @Override
    public void run() {
        MyCasLock myCasLock=new MyCasLock();
        myCasLock.lock();
        System.out.println("线程"+Thread.currentThread().getName()+"开始进行");
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"结束进行");
        myCasLock.unlock();
    }
}
