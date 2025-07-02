package com.wangziyu.jvmstudy.hardwarestudy;

import java.util.concurrent.TimeUnit;

public class CPUDisOrderTest {
    private static int a=0,b=0,x=0,y=0;
    private static long count;
    private static boolean flag;
    public static void main(String[] args) throws InterruptedException {
        while (!flag){
            x = 0; y = 0;
            a = 0; b = 0;
       Thread t1=new Thread(()->{
           a=2;
           x=b;
       });
        Thread t2=new Thread(()->{
            b=2;
            y=a;

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
            count++;
        if(x==0&&y==0){
                System.out.println("第"+count+"次CPU发生了指令重排序");
                flag=true;
            }
    }




    }

    public static void method1(){
        a=2;
        x=b;
    }

    public static void method2(){
       b=2;
       y=a;
    }

}
