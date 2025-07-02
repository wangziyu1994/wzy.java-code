package com.wangziyu.mulpthread.collectionstudy;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class ListTest {

    public static List<String> tickArrayList = new ArrayList<>();
    public static int ticketSize=100000;
    public static int threadSize=10;
    public static List<String> tickLinkedList = new LinkedList<>();
    public static Vector<String> vectorList = new Vector<>();
    public static Queue<String> cocurrentQueueList = new ConcurrentLinkedQueue<>();
    public static List<String> copyAndWriteList=new CopyOnWriteArrayList<>();


    static {
        for (int i = 0; i <= ticketSize; i++) {
            tickArrayList.add("票编号:" + i);
            tickLinkedList.add("票编号:" + i);
            vectorList.add("票编号:" + i);
            cocurrentQueueList.add("票编号:" + i);
            copyAndWriteList.add("票编号:" + i);
        }
    }

    public static void main(String[] args) throws IOException {
        LocalTime startTime=LocalTime.now();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(threadSize,new Thread(()->{
            LocalTime endTime=LocalTime.now();
            System.out.println("总共耗费"+ ChronoUnit.MILLIS.between(startTime,endTime)+"毫秒");
        }));


        //arrayListTest(cyclicBarrier);//测试多线程ArrayList取数效率以及安全性 1635ms  线程不安全
        //linkedListTest(cyclicBarrier);//测试多线程ArrayList取数效率以及安全性  1334ms 线程不安全
        //vectorTest(cyclicBarrier); //测试多线程vector取数效率以及安全性  1854ms 线程安全
        //conQueueTest(cyclicBarrier);// 测试多线程ConcurrentLinkedQueue取数效率以及安全性  18465ms 线程安全
        copyAndWriteList(cyclicBarrier); //测试多线程copyAndWriteArrayList  线程安全


    }


    public static void arrayListTest(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                while (tickArrayList.size() > 0) {
                    System.out.println("销售了" + tickArrayList.remove(0));
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "AT" + i).start();

        }
    }

    public static void linkedListTest(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                while (tickLinkedList.size() > 0) {
                    System.out.println("销售了" + tickLinkedList.remove(0));
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "LT" + i).start();
        }
    }

    public static void vectorTest(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                while (vectorList.size() > 0) {
                    System.out.println("销售了" + vectorList.remove(0));
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "VT" + i).start();
        }
    }

    public static void conQueueTest(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                while (cocurrentQueueList.size() > 0) {
                    System.out.println("销售了" + cocurrentQueueList.poll());
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "CQ" + i).start();
        }
    }


    public static void copyAndWriteList(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                while (copyAndWriteList.size() > 0) {
                    //System.out.println("销售了" + copyAndWriteList.remove(0));
                    System.out.println("销售了" + copyAndWriteList.get(0));
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "CW" + i).start();
        }
    }

}



