package com.wangziyu.mulpthread;

public class A1B2C3Test {

    static StringBuffer stringBuffer=new StringBuffer();
    public static void main(String[] args) {
        thread1();

    }

    public static void thread1(){
        Thread t1=new Thread(()->{

                for (int i = 1; i <= 26; i++) {
                    synchronized (A1B2C3Test.class) {
                        if(stringBuffer.length()==0){
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
            System.out.println(Thread.currentThread().getName()+"finish");
            if(stringBuffer.length()==69) {
                System.out.println(stringBuffer.toString());
            }
        },"T2");


        Thread t2=new Thread(()->{
                for (int i = 97; i <= 122; i++) {
                    synchronized (A1B2C3Test.class) {
                    char chr = (char) i;
                        stringBuffer.append(String.valueOf(chr));
                        try {
                            A1B2C3Test.class.notify();
                            A1B2C3Test.class.wait();
                            if(i==122){
                                A1B2C3Test.class.notify();
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                }
            }
            System.out.println(Thread.currentThread().getName()+"finish");
            if(stringBuffer.length()==69) {
                System.out.println(stringBuffer.toString());
            }
        },"T1");

        t2.start();
        t1.start();
    }
}
