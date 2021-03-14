package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;



public class LockSupportTest {
    @Test
    public void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
            }
        });

        t1.start();
        TimeUnit.SECONDS.sleep(8);
        System.out.println("after  8 seconds");
        LockSupport.unpark(t1);
    }
}
