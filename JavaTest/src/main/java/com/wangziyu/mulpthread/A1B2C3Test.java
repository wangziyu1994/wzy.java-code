package com.wangziyu.mulpthread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class A1B2C3Test {

    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        //synMethod();
        reenLockMethod();
    }

    public static void synMethod() {
        Thread t1 = new Thread(() -> {

            for (int i = 1; i <= 26; i++) {
                synchronized (A1B2C3Test.class) {
                    if (stringBuffer.length() == 0) {
                        try {
                            A1B2C3Test.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    stringBuffer.append(String.valueOf(i));
                    try {
                        A1B2C3Test.class.notify();
                        A1B2C3Test.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "finish");
            if (stringBuffer.length() == 69) {
                System.out.println(stringBuffer.toString());
            }
        }, "T2");


        Thread t2 = new Thread(() -> {
            for (int i = 97; i <= 122; i++) {
                synchronized (A1B2C3Test.class) {
                    char chr = (char) i;
                    stringBuffer.append(String.valueOf(chr));
                    try {
                        A1B2C3Test.class.notify();
                        A1B2C3Test.class.wait();
                        if (i == 122) {
                            A1B2C3Test.class.notify();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
            System.out.println(Thread.currentThread().getName() + "finish");
            if (stringBuffer.length() == 69) {
                System.out.println(stringBuffer.toString());
            }
        }, "T1");

        t2.start();
        t1.start();
    }


    public static void reenLockMethod() {
        ReentrantLock lock = new ReentrantLock();
        Condition charCondition=lock.newCondition();
        Condition numCondition=lock.newCondition();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                lock.lock();
                if (stringBuffer.length() == 0) {
                    try {
                        numCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stringBuffer.append(String.valueOf(i));
                //System.out.println(String.valueOf(String.valueOf(i)));
                charCondition.signal();
                try {
                    numCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "finish");
            if (stringBuffer.length() == 69) {
                System.out.println(stringBuffer.toString());
            }
        }, "T2");


        Thread t2 = new Thread(() -> {
            for (int i = 97; i <= 122; i++) {
                lock.lock();
                char chr = (char) i;
                stringBuffer.append(String.valueOf(chr));
                //System.out.println(String.valueOf(chr));
                numCondition.signal();
                try {
                    charCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "finish");
            if (stringBuffer.length() == 69) {
                System.out.println(stringBuffer.toString());
            }
        }, "T1");

        t1.start();
        t2.start();
    }
}
