package com.wangziyu.mulpthread.threadpoolstudy;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingledThreadPoolTest {
    private static final int threadSize=10;
    public static void main(String[] args) {
        singleThreadPoolTest();
    }

    public static void singleThreadPoolTest(){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for(int i=0;i<=threadSize-1;i++){
            System.out.println(i+"线程池状态"+executorService);
            Callable<String> callable=new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String start=Thread.currentThread().getName()+"执行过程中.........";
                    System.out.println(start);
                    TimeUnit.SECONDS.sleep(10);
                    String result=Thread.currentThread().getName()+"执行完成";
                    System.out.println(result);
                    return result;
                }
            };

            executorService.submit(callable);
        }


    }
}
