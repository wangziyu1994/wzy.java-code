package com.wangziyu.mulpthread.callfutstudy;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        callAbleTest();
    }


    public static void callAbleTest() throws ExecutionException, InterruptedException {
        Callable<String>  callable= new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+":线程执行完成");
                String result=Thread.currentThread().getName()+":Finish";
                return result;
            }
        };
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<String> result=executorService.submit(callable);
        System.out.println("线程任务完成,返回执行结果"+result.get());

    }



}
