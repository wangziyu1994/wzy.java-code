package com.wangziyu.mulpthread.model;

public class MyThread1 implements Runnable{

    public  volatile int num=30;
    @Override
    public void run() {
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+"=============="+i);
            num=num-1;
            if(i==5) {
                System.out.println(Thread.currentThread().getName()+"开始yield");
                Thread.currentThread().yield();
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
