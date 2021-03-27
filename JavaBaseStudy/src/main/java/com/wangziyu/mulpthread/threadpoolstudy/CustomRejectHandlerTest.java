package com.wangziyu.mulpthread.threadpoolstudy;

import java.util.concurrent.*;

public class CustomRejectHandlerTest {
    private static final int threadSize = 10;

    public static void main(String[] args) {
        customRejectHandlerTest();
    }

    static class customRejectHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(executor);
            System.out.println("超过线程最大容量,执行自定义拒绝策略");
        }
    }

    public static void customRejectHandlerTest() {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new customRejectHandler());
        for (int i = 0; i <= threadSize - 1; i++) {
            Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int var = (int) (Math.random() * 10);
                    String start = Thread.currentThread().getName() + "执行过程中.........";
                    System.out.println(start);
                    TimeUnit.SECONDS.sleep(100);
                    String result = Thread.currentThread().getName() + "执行完成";
                    System.out.println(result);
                    return result;
                }
            };
            executorService.submit(callable);
        }

    }

}


