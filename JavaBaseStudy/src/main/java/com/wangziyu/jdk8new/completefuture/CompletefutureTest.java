package com.wangziyu.jdk8new.completefuture;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

public class CompletefutureTest {
    CompletableFuture completefuture1;
    CompletableFuture completefuture2;
    Executor executor;
    Runnable task1;
    Callable<Integer> task2;
    Callable<Integer> task3;
    Integer result1;
    Integer result2;
    Integer result3;

    @Before
    public void prepare(){
        executor= Executors.newFixedThreadPool(3);
       task1=()->{
            System.out.println(Thread.currentThread().getName()+":执行成功");
        };

       task2=()->{
            System.out.println(Thread.currentThread().getName()+":执行成功");
            return 0;
        };

      task3=()->{
            System.out.println(Thread.currentThread().getName()+":执行成功");
            return 0;
        };

    }



    @Test
    public void test1() throws ExecutionException, InterruptedException {
        completefuture1=CompletableFuture.runAsync(task1);
        completefuture2=CompletableFuture.runAsync(task1,executor);
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        completefuture2=CompletableFuture.completedFuture("success").runAsync(task1,executor).thenApply((e)->{
            return "applySuccess";
        });
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        completefuture1=CompletableFuture.runAsync(task1);
    }
    @Test
    public void test4() throws ExecutionException, InterruptedException {
        completefuture1=CompletableFuture.runAsync(task1);
    }



    @After
    public void printResult(){

      //  System.out.println("result1: "+completefuture1==null?"null":completefuture1.getNow("无结果"));

        System.out.println("result2: "+completefuture2==null?"null":completefuture2.getNow("无结果"));
    }
}
