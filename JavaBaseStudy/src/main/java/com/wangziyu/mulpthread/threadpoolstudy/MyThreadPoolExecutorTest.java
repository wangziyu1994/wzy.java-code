package com.wangziyu.mulpthread.threadpoolstudy;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPoolExecutorTest {

    private BlockingQueue blockingQueue = new ArrayBlockingQueue(5);
    private RejectedExecutionHandler rejectedHandler;
    private int corePoolSize = 5;
    private int maxPoolSize = 10;
    private int livingTime = 5 * 1000;
    private ThreadPoolExecutor myThreadPool;
    private Runnable task;
    private int taskCount = 5;

    int COUNT_BITS = Integer.SIZE - 3;
    int CAPACITY = (1 << COUNT_BITS) - 1;
    int RUNNING = -1 << COUNT_BITS;
    int SHUTDOWN = 0 << COUNT_BITS;
    int STOP = 1 << COUNT_BITS;
    int TIDYING = 2 << COUNT_BITS;
    int TERMINATED = 3 << COUNT_BITS;
    AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    @Before
    public void prepare() {
        task = () -> {
            System.out.println("我是任务[" + Thread.currentThread().getName() + "]");
        };
        myThreadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize, livingTime, TimeUnit.MILLISECONDS, blockingQueue);
    }


    @Test
    public void test() {
        for (int i = 0; i < taskCount; i++) {
            myThreadPool.execute(task);
            myThreadPool.submit(()->{
                return 1;
            });
        }
        myThreadPool.shutdown();
    }


    @Test
    public void printRunnngState() {
       int c=ctl.get();
       int rs=runStateOf(c);
       int wc=workerCountOf(c);
        System.out.println(c);
       System.out.println(rs);
        System.out.println(wc);
    }

    public int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    private  int runStateOf(int c)     { return c & ~CAPACITY; }
    private  int workerCountOf(int c)  { return c & CAPACITY; }
}
