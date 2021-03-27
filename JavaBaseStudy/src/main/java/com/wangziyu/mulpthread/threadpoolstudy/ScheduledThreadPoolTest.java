package com.wangziyu.mulpthread.threadpoolstudy;

import com.wangziyu.mulpthread.callfutstudy.FutureTaskTest;

import java.util.concurrent.*;

public class ScheduledThreadPoolTest {
    private static final int threadSize=10;
    public static void main(String[] args) throws InterruptedException {
        scheduledThreadPoolTest();
    }


    public static  void scheduledThreadPoolTest() throws InterruptedException {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(10);
                FutureTask<String> futureTask = new FutureTask<String>(() -> {
                    int var = (int) (Math.random() * 10);
                    String start = Thread.currentThread().getName() + "执行过程中.........";
                    System.out.println(start);
                    TimeUnit.SECONDS.sleep(var);
                    String result = Thread.currentThread().getName() + "执行完成";
                    System.out.println(result);
                    return result;
                });
                executorService.scheduleAtFixedRate(futureTask, 10, 5, TimeUnit.SECONDS);





        while (!executorService.isShutdown()){
            TimeUnit.SECONDS.sleep(2);
            System.out.println(executorService);
        }
        }


    }

