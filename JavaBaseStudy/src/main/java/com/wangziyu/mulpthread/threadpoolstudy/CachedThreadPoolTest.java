package com.wangziyu.mulpthread.threadpoolstudy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolTest {
    private static final int threadSize=10;
    public static void main(String[] args) throws InterruptedException {
        cachedThreadPoolTest();
    }

    public static void cachedThreadPoolTest() throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<=threadSize-1;i++){
            Callable<String> callable=new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int var=(int)(Math.random()*10);
                    System.out.println(var);
                    String start=Thread.currentThread().getName()+"执行过程中.........";
                    System.out.println(start);
                    TimeUnit.SECONDS.sleep(var);
                    String result=Thread.currentThread().getName()+"执行完成";
                    System.out.println(result);
                    return result;
                }
            };

            executorService.submit(callable);
        }

        while (!executorService.isShutdown()){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(executorService);
        }


    }
}
