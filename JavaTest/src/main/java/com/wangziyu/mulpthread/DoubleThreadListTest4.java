package com.wangziyu.mulpthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * 一个容器,两个线程，一个线程添加元素,另一个元素监控容器，当容器元素达到5时，打印一句话，然后停止.
 */
public class DoubleThreadListTest4 {
    private static List<Integer> targetList = new ArrayList();

    static Thread t1=null;
    static Thread t2=null;


    public static void main(String[] args) {
        //test1();//使用单LockSupport实现
        test2();//使用双LockSupport实现
    }


    /**
     * 使用单LockSupport实现
     */
    public static void test1() {


        Thread t2 = new Thread(() -> {
                while (true) {
                    if (targetList.size() != 5) {
                        try {
                            LockSupport.park();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("线程" + Thread.currentThread().getName() + "元素个数为5");
                        break;
                    }
                }

        }, "T2");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 9; i++) {
                targetList.add(i);
                System.out.println("线程" + Thread.currentThread().getName() + "添加完元素" + targetList.get(i));
                try {
                    if (targetList.size() == 5) {
                        LockSupport.unpark(t2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "T1");


        t2.start();
        t1.start();
    }



    /**
     * 使用双LockSupport实现
     */
    public static void test2() {


         t2 = new Thread(() -> {
               System.out.println("T2运行");
                        LockSupport.park();
                        System.out.println("线程" + Thread.currentThread().getName() + "元素个数为5");
                        LockSupport.unpark(t1);


        }, "T2");

         t1 = new Thread(() -> {
            for (int i = 0; i <= 9; i++) {
                targetList.add(i);
                System.out.println("线程" + Thread.currentThread().getName() + "添加完元素" + targetList.get(i));
                try {
                    if (targetList.size() == 5) {
                        LockSupport.unpark(t2);
                        LockSupport.park();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "T1");


        t1.start();
        t2.start();
    }

}
