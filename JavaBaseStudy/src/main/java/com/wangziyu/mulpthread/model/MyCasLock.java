package com.wangziyu.mulpthread.model;

import java.util.concurrent.atomic.AtomicReference;

public class MyCasLock {
    public static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        while (true) {
            boolean flag = atomicReference.compareAndSet(null, currentThread);
            if (flag) {
                break;
            }
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        Thread memoryThread = atomicReference.get();
        if (currentThread != memoryThread) {
            throw new IllegalMonitorStateException();
        }
        atomicReference.compareAndSet(currentThread, null);
    }
}
