package com.wangziyu.mulpthread.callfutstudy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    futureTaskTest();
    }


    public static void futureTaskTest() throws ExecutionException, InterruptedException {
        //可以传入future  runnable对象
        FutureTask futureTask=new FutureTask(()->{
            System.out.println(Thread.currentThread().getName()+":线程执行完成!");
            String result=Thread.currentThread().getName()+":Finish";
            return result;
        });

        Thread thread=new Thread(futureTask,"Thread1");
        thread.start();
        System.out.println("线程执行完成,返回"+futureTask.get());
    }
}
