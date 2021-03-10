package com.wangziyu.mulpthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 一个容器,两个线程，一个线程添加元素,另一个元素监控容器，当容器元素达到5时，打印一句话，然后停止.
 */
public class DoubleThreadListTest3 {
    private static List<Integer> targetList = new ArrayList();
    static CountDownLatch countDownLatch=new CountDownLatch(1);
    static CountDownLatch secondCountLatch=new CountDownLatch(1);

    public static void main(String[] args) {
        //test1();//使用单CountDownLatch实现 失败
        test2();//使用双CountDownLatch实现 成功
    }


    /**
     * 使用单CountDownLatch实现
     * 仍然不能保持同步
     */
    public static void test1() {
        Thread t1 = new Thread(() -> {
            synchronized (DoubleThreadListTest2.class) {
                for (int i = 0; i <= 9; i++) {
                    targetList.add(i);
                    System.out.println("线程" + Thread.currentThread().getName() + "添加完元素" + targetList.get(i));
                    try {
                        if (targetList.size() == 5) {
                            countDownLatch.countDown();
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
                            countDownLatch.await();
                            System.out.println("线程" + Thread.currentThread().getName() + "元素个数为5");
                        } catch (Exception e) {
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
     * 使用双CountDownLatch实现
     * 仍然不能保持同步
     */
    public static void test2() {
        Thread t1 = new Thread(() -> {
                for (int i = 0; i <= 9; i++) {
                    targetList.add(i);
                    System.out.println("线程" + Thread.currentThread().getName() + "添加完元素" + targetList.get(i));
                    try {
                        if (targetList.size() == 5) {
                            countDownLatch.countDown();
                            secondCountLatch.await();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }, "T1");


        Thread t2 = new Thread(() -> {
    while(true) {
        if (targetList.size() != 5) {
            try {
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("线程" + Thread.currentThread().getName() + "元素个数为5");
            secondCountLatch.countDown();
            break;
        }
    }

        }, "T2");


        t1.start();
        t2.start();
    }
}
