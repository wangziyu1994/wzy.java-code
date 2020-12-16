package com.mulpthread.test;

import com.mulpthread.model.MyThread1;
import com.mulpthread.model.Bank;
import org.junit.jupiter.api.Test;

public class ThreadTest {
    public static volatile int num=30;
    @Test
    public void test1(){
        double d=100;
        System.out.printf("%10.2f from %d to %d",d,10,20);
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
      final int NACCOUNTS=10;
      final double INITIAL_BALANCE=1000;
      final double MAX_AMOUNT=1000;
      final int  DELAY=10;
       Bank bank=new Bank(NACCOUNTS,INITIAL_BALANCE);
       for(int i=0;i<NACCOUNTS;i++){
          final int fromAccount=i;
          Runnable runnable=()->{
              try{
                    while (true){
                        int toAccount=(int)(bank.getSize()*Math.random());
                        //double amount=MAX_AMOUNT*Math.random();
                        double amount=20;
                        //无锁的非同步转账
                        //bank.transFer(fromAccount,toAccount,amount);
                        //有锁的同步转账
                       // bank.reentrantLockTransFer(fromAccount,toAccount,amount);
                        //有锁带有条件对象的转账
                        bank.conditionalTransFer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY*Math.random()));
                    }
              }
              catch (InterruptedException e){

              }
          };
          Thread t=new Thread(runnable);
          t.start();


       }


    }


    @Test
    public void test5()  {
        final int NACCOUNTS=10;
        final double INITIAL_BALANCE=1000;
        final double MAX_AMOUNT=1000;
        final int  DELAY=10;
        Bank bank=new Bank(NACCOUNTS,INITIAL_BALANCE);
        for(int i=0;i<NACCOUNTS;i++){
             int fromAccount=i;
            int toAccount=(int)(bank.getSize()*Math.random());
            //double amount=MAX_AMOUNT*Math.random();
            double amount=20;
            Runnable runnable=new Runnable(){
                @Override
                public void run() {
                    bank.syschronizedTransFer(fromAccount, toAccount, amount);
                }
            };
            Thread t=new Thread(runnable);
            t.start();

            if(i==5){
                Runnable runnable1=()->{
                    System.out.println("线程"+Thread.currentThread().getName()+"开始修改共享变量");
                    bank.accountsList.set(5,50.0);
                };
                Thread t1=new Thread(runnable1);
                t1.start();
            }

        }


    }
}
