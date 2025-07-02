package com.wangziyu.mulpthread;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个容器,两个线程，一个线程添加元素,另一个元素监控容器，当容器元素达到5时，打印一句话，然后停止.
 */
public class DoubleThreadListTest2 {
    private static List<Integer> targetList = new ArrayList();

    public static void main(String[] args) {
        //test1();//由于notify方法不释放锁，所以监控线程被wait后并不会被唤醒
        //test2();//在监控线程wait后，添加线程到达条件时notify唤醒监控线程并且wait释放锁,监控线程完成任务后notify唤醒添加线程，
        // 执行完之后自动释放锁，添加线程得到锁，并且被唤醒，开始重新执行.
    }


    /**
     * 使用单wait  notify实现
     */
    public static void test1() {
        Thread t1 = new Thread(() -> {
            synchronized (DoubleThreadListTest2.class) {
                for (int i = 0; i <= 9; i++) {
                    targetList.add(i);
                    System.out.println("线程" + Thread.currentThread().getName() + "添加完元素" + targetList.get(i));
                    try {
                        if (targetList.size() == 5) {
                            DoubleThreadListTest2.class.notify();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "T1");


        Thread t2 = new Thread(() -> {
            synchronized (DoubleThreadListTest2.class) {
                while (true) {
                    if (targetList.size() != 5) {
                        try {
                            DoubleThreadListTest2.class.wait();
                            System.out.println("线程" + Thread.currentThread().getName() + "元素个数为5");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }, "T2");


        t1.start();
        t2.start();
    }

    /**
     * 使用双wait  notify实现
     */
    public static void test2() {
        Thread t1 = new Thread(() -> {
            synchronized (DoubleThreadListTest2.class) {
                for (int i = 0; i <= 9; i++) {
                    targetList.add(i);
                    System.out.println("线程" + Thread.currentThread().getName() + "添加完元素" + targetList.get(i));
                    try {
                        if (targetList.size() == 5) {
                            DoubleThreadListTest2.class.notify();//唤醒监控线程
                            DoubleThreadListTest2.class.wait();//添加线程执行wait方法释放锁,让监控线程运作
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "T1");


        Thread t2 = new Thread(() -> {
            synchronized (DoubleThreadListTest2.class) {
                while (true) {
                    if (targetList.size() != 5) {
                        try {
                            DoubleThreadListTest2.class.wait();
                            System.out.println("线程" + Thread.currentThread().getName() + "元素个数为5");
                            DoubleThreadListTest2.class.notify();//唤醒添加进程,执行完之后锁也被释放
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }

            }
        }, "T2");

        t2.start();
        t1.start();

    }
}
