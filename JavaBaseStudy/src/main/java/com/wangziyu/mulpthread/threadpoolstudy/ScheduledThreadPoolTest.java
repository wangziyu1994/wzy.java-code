package com.wangziyu.mulpthread.threadpoolstudy;

import com.wangziyu.mulpthread.callfutstudy.FutureTaskTest;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledThreadPoolTest {
    private static final int threadSize = 10;
    private CountDownLatch mainWait;

    @Before
    public void prepare(){
        mainWait=new CountDownLatch(1);
    }


    @Test
    public void scheduledThreadPoolTest() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
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
        while (!executorService.isShutdown()) {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(executorService);
        }
    }


    @Test
    public void testFixed() throws InterruptedException {
        ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(4);
        Runnable futureTask = () -> {
            int var = 3;
            String start = LocalDateTime.now() + " " + Thread.currentThread().getName() + "执行过程中.........";
            System.out.println(start);
            try {
                TimeUnit.SECONDS.sleep(var);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = Thread.currentThread().getName() + "执行完成";
            //System.out.println(result);
        } ;
        executorService1.scheduleAtFixedRate(futureTask, 0, 1, TimeUnit.SECONDS);
        mainWait.await();
    }

    @Test
    public void testFixedWithDelay() throws InterruptedException {
        ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(1);
        Runnable futureTask = () -> {
            int var = 5;
            String start = LocalDateTime.now() + " " + Thread.currentThread().getName() + "执行过程中.........";
            System.out.println(start);
            try {
                TimeUnit.SECONDS.sleep(var);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = Thread.currentThread().getName() + "执行完成";
            //System.out.println(result);
        } ;
        executorService1.scheduleWithFixedDelay(futureTask, 0, 2, TimeUnit.SECONDS);
        mainWait.await();
    }


}

