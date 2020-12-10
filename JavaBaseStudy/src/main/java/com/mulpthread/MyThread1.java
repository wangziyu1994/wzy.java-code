package com.mulpthread;

public class MyThread1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=4;i++){
            ThreadTest.num--;
            System.out.println(Thread.currentThread().getName()+"=============="+ThreadTest.num);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
