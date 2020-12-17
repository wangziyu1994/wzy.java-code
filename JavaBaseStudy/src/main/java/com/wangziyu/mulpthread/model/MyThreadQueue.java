package com.wangziyu.mulpthread.model;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadQueue<T> {
    public  BlockingQueue<T> queue;

    public MyThreadQueue(BlockingQueue<T> queue){
        this.queue=queue;
    }

}
