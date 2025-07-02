package com.wangziyu.mulpthread.threadpoolstudy;

import java.sql.Time;
import java.util.concurrent.*;

public class SingledThreadPoolTest {
    private static final int threadSize=10;
    public static void main(String[] args) throws InterruptedException {
        singleThreadPoolTest();
    }

    public static void singleThreadPoolTest() throws InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
            /*    thread.setUncaughtExceptionHandler((t,e)->{
                    System.out.println("未捕获异常启动");
                });*/
                return thread;
            }
        });
        for(int i=0;i<=threadSize-1;i++) {
            System.out.println(i + "线程池状态" + executorService);
            Callable<String> callable = new Callable<String>() {
                @Override
                public String call()  {
                    String start = Thread.currentThread().getName() + "执行过程中.........";
                    System.out.println(start);
                    String result = Thread.currentThread().getName() + "执行完成";
                    System.out.println(result);
                    int var = 5 / 0;
                    return result;
                }
            };

            executorService.submit(callable);
        }

        TimeUnit.SECONDS.sleep(10);


        for(int i=0;i<=threadSize-1;i++) {
            Runnable runnable=new Runnable(){
                @Override
                public void run(){
                    String start=Thread.currentThread().getName()+"执行过程中.........";
                    System.out.println(start);
                    String result=Thread.currentThread().getName()+"执行完成";
                    System.out.println(result);
                    int var=5/0;
                }
            };
            executorService.submit(runnable);
            System.out.println("提交任务");
        }
       /* while (!executorService.isShutdown()){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(executorService);
        }*/

    }
}
