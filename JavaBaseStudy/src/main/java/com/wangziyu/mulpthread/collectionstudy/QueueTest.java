package com.wangziyu.mulpthread.collectionstudy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;
public class QueueTest {
    public static int size = 5;
    public static Queue<String> commonQueue = new ConcurrentLinkedQueue<>();//非阻塞线程安全的队列  //无界队列
    public static BlockingQueue<String> blockArrayQueue = new ArrayBlockingQueue<>(size); //有界队列
    public static BlockingDeque<String> blockLinkQueue = new LinkedBlockingDeque<>(size); //有界队列
    public static Queue<String> pritorQueue = new PriorityQueue<>(size); //存在顺序取数
    public static BlockingQueue<MyTask> delayQueue = new DelayQueue<>(); //
    public static BlockingQueue<String> synchronousQueue = new SynchronousQueue();//容量为0的队列 如果末发现取请求，则不能添加
    public static LinkedTransferQueue<String> tranferQueue = new LinkedTransferQueue<>();//容量为0的队列 如果末发现取请求，则不能添加


    static {
        for (int i = 0; i < size; i++) {
            char charelemnt = (char) (97 + i);
            //add方法遇到容量满时，会报错,offer则不会。成功返回true失败返回false
            commonQueue.offer(String.valueOf(charelemnt));
        }
        pritorQueue.offer("b");
        pritorQueue.offer("c");
        pritorQueue.offer("a");
        pritorQueue.offer("e");
        pritorQueue.offer("d");
    }

    public static void main(String[] args) throws InterruptedException {
        //commonUnBlockingQueueTest();
        //arrayBlockingQueueTest();
        //pritorQueueTest();
        //delayedQueueTest();
       // synchronQueueTest();
        tranferQueueTest();
    }


    public static void commonUnBlockingQueueTest() {
        System.out.println("初始QUEUE长度" + commonQueue.size());
        // System.out.println(commonQueue.peek());
        // System.out.println("peek过后QUEUE长度"+commonQueue.size());

        System.out.println(commonQueue.poll());
        System.out.println("poll过后QUEUE长度" + commonQueue.size());


    }


    public static void arrayBlockingQueueTest() throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < size + 1; i++) {
                char charelemnt = (char) (97 + i);
                try {
                    blockArrayQueue.put(String.valueOf(charelemnt));
                    System.out.println(Thread.currentThread().getName() + "线程元素放入" + charelemnt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < size + 7; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "取走" + blockArrayQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


    public static void pritorQueueTest() {
        for (int i = 0; i < size; i++) {
            System.out.println(pritorQueue.poll());
        }
    }


    static class MyTask implements Delayed {
        String name;
        long runningTime;

        public MyTask(String name, long runningTime) {
            this.name = name;
            this.runningTime = runningTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getRunningTime() {
            return runningTime;
        }

        public void setRunningTime(long runningTime) {
            this.runningTime = runningTime;
        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "name='" + name + '\'' +
                    ", runningTime=" + runningTime +
                    '}';
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }
    }


    public static void delayedQueueTest() throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask myTask1 = new MyTask("t1", now + 3000);
        MyTask myTask2 = new MyTask("t2", now + 500);
        MyTask myTask3 = new MyTask("t3", now + 4000);
        MyTask myTask4 = new MyTask("t4", now + 3500);
        MyTask myTask5 = new MyTask("t5", now + 1000);
        delayQueue.put(myTask1);
        delayQueue.put(myTask2);
        delayQueue.put(myTask3);
        delayQueue.put(myTask4);
        delayQueue.put(myTask5);

        for (int i = 0; i < size; i++) {
            System.out.println(delayQueue.take().toString());
        }
    }

    public static void synchronQueueTest() throws InterruptedException {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "取走 " + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + "准备放入元素1");
        synchronousQueue.put("元素1");
        System.out.println(Thread.currentThread().getName() + "准备放入元素2");
        synchronousQueue.put("元素2");
        System.out.println(Thread.currentThread().getName() + "放入元素成功,且已被取走");
    }


    public static void tranferQueueTest() throws InterruptedException {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                for(int i=0;i<2;i++) {
                    System.out.println(Thread.currentThread().getName() + "取走 " + tranferQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + "准备放入元素1");
        tranferQueue.transfer("元素1");
        System.out.println(Thread.currentThread().getName() + "准备放入元素2");
        tranferQueue.transfer("元素2");
        System.out.println(Thread.currentThread().getName() + "准备放入元素3");
        tranferQueue.transfer("元素3");
        System.out.println(Thread.currentThread().getName() + "放入元素成功,且已被取走");
    }
}
