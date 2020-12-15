package com.mulpthread;

import com.mulpthread.Model.Bank;
import org.junit.jupiter.api.Test;

public class ThreadTest {
    public static volatile int num=30;
    @Test
    public void test1(){

        Thread myThread1=new Thread(new MyThread1());
        Thread myThread2=new Thread(new MyThread1());
        Thread myThread3=new Thread(new MyThread1());
        Thread myThread4=new Thread(new MyThread1());
        Thread myThread5=new Thread(new MyThread1());
        Thread myThread6=new Thread(new MyThread1());
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
        myThread6.start();
    }


    /**
     * 线程join方法 让执行此方法的线程对象优先执行，其他线程进入堵塞状态
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {

        Thread myThread1=new Thread(new MyThread1(),"子线程1");
        myThread1.start();
        for(int i=0;i<=30;i++){
            myThread1.join();
            System.out.println("主线程执行"+i);
        }

    }

    @Test
    public void test3()  {

        Thread myThread1=new Thread(new MyThread1(),"子线程1");
        Thread myThread2=new Thread(new MyThread1(),"子线程2");
        Thread myThread3=new Thread(new MyThread1(),"子线程3");
        myThread1.start();
        myThread2.start();
        myThread3.start();


    }

    @Test
    public void test4()  {
        int accountSum=100;
        double sumBal=1000;
        double max_amount=1000;
        int delay=10;
       Bank bank=new Bank(100,1000);
       for(int i=0;i<100;i++){
          int from=i;
          Runnable runnable=()->{
              try{
                    while (true){
                        int toAccount=bank.getSize()*Math.random();
                        double amount=max_amount*Math.random();

                    }
              }
          }
       }


    }
}
