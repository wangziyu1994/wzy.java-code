package com.wangziyu.referencestudy;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.ref.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReferenceTest {

    /**
     * 强引用
     */
    @Test
    public void test1() throws IOException, InterruptedException {
        MyObject myObject = new MyObject("强引用对象");
        //myObject = null;
        System.gc();
        System.out.println("GC回收垃圾对象");
        TimeUnit.SECONDS.sleep(5);
    }


    /**
     * 软引用
     */
    @Test
    public void test2() throws InterruptedException {
        SoftReference<byte[]> softReference = new SoftReference(new byte[1024 * 1024 * 10]);
        softReference.clear();
        System.gc();
        System.out.println("GC回收垃圾对象");
        System.out.println(softReference.get());
        /*byte[] b = new byte[1024 * 1024 * 6];
        System.out.println("创建一个容量大的数组，让25M堆内存不够使用");
        System.out.println(softReference.get());*/
        TimeUnit.SECONDS.sleep(5);
    }


    /**
     * 弱引用
     */
    @Test
    public void test3() {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject("弱对象"));
        System.out.println(weakReference.get());
        System.gc();
        System.out.println("GC回收垃圾对象");
        System.out.println(weakReference.get());
    }


    @Test
    public void test4() throws InterruptedException {
        List list = new LinkedList<>();
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue();
        PhantomReference<MyObject> phantomReference = new PhantomReference(new MyObject("虚引用对象"), referenceQueue);
        System.out.println("aaa"+phantomReference.get());
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(new byte[1024 * 1024]);
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends MyObject> reference = referenceQueue.poll();
                if (reference != null) {
                    System.out.println("虚引用对象被回收了" + reference);
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(20);
    }

}
