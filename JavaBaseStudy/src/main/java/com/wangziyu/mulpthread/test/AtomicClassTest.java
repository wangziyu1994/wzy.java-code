package com.wangziyu.mulpthread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicClassTest {

    public Integer num=0;
    public volatile Integer volatileNum=0;
    public AtomicInteger atomicNum=new AtomicInteger(0);
    public int threadNum=5;
    public AtomicReference<Integer> atomicReference=new AtomicReference(100);
    public AtomicStampedReference<Integer> versionReerence=new AtomicStampedReference(100,1);


    /**
     * 测试atomic 自增自减  线程安全
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        Runnable runable=()->{
            for(int i=0;i<1000;i++){
                num++;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        Runnable runable1=()->{
            for(int i=0;i<1000;i++){
                volatileNum++;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runable2=()->{
            for(int i=0;i<1000;i++){
                atomicNum.incrementAndGet();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread[] threads1=new Thread[threadNum];
        Thread[] threads2=new Thread[threadNum];
        Thread[] threads3=new Thread[threadNum];
        for(int i=0;i<5;i++){
            threads1[i]=new Thread(runable);

        }
        for(int i=0;i<5;i++){
            threads2[i]=new Thread(runable1);

        }
        for(int i=0;i<5;i++){
            threads3[i]=new Thread(runable2);

        }
        for(int i=0;i<5;i++){
            threads1[i].start();
            threads2[i].start();
            threads3[i].start();
        }

        Thread.sleep(10000);
        System.out.println("普通方式自增"+num);
        System.out.println("volatile方式自增"+volatileNum);
        System.out.println("atomic方式自增"+atomicNum);

    }

    /**
     * 测试compareAndSwap  ABA问题
     */
    @Test
    public void test1(){
        new Thread(()->{
            Integer expect=atomicReference.get();
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"执行3秒后,修改值是否成功"+atomicReference.compareAndSet(expect,2020)+"当前值为"+atomicReference.get());
        },"A").start();


        new Thread(()->{
                Integer expect1=atomicReference.get();
                atomicReference.compareAndSet(expect1,101);
            System.out.println("线程"+Thread.currentThread().getName()+"偷偷修改值为101");
                Integer expect2=atomicReference.get();
                atomicReference.compareAndSet(expect2,100);
                System.out.println("线程"+Thread.currentThread().getName()+"偷偷修改值为100");
        },"B").start();
    }


    /**
     * 测试compareAndSwap  加入版本号解决ABA问题
     */
    @Test
    public void test2(){
        new Thread(()->{
        Integer expect=versionReerence.getReference();
        int version=versionReerence.getStamp();
        System.out.println("线程"+Thread.currentThread().getName()+"开始修改值,版本号"+version);
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"执行3秒后,修改值是否成功"+versionReerence.compareAndSet(expect,2020,version,version+1)+"当前值为"+versionReerence.getReference()+"版本号"+versionReerence.getStamp());
    },"A").start();


        new Thread(()->{
        Integer expect1=versionReerence.getReference();
        int version1=versionReerence.getStamp();
        versionReerence.compareAndSet(expect1,101,version1,version1+1);
        System.out.println("线程"+Thread.currentThread().getName()+"偷偷修改值为101,版本号"+versionReerence.getStamp());
        Integer expect2=versionReerence.getReference();
        int version2=versionReerence.getStamp();
        versionReerence.compareAndSet(expect2,100,version2,version2+1);
        System.out.println("线程"+Thread.currentThread().getName()+"偷偷修改值为100,版本号"+versionReerence.getStamp());
    },"B").start();
}

}
