package com.wangziyu.jvmstudy.hardwarestudy;

import com.wangziyu.jvmstudy.classsfilestudy.CommonClassFile;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CachLineMESITest {
    public static final int count=100000000;
    public static final int size = 2;
    public static volatile long[] longarr1 = new long[size];
    public static volatile long[] longarr2 = new long[8 * size];
    public static CyclicBarrier cyclicBarrier=new CyclicBarrier(3);

    static {
        for (int i = 0; i < size; i++) {
            longarr1[i] = 100L;
        }
        for (int i = 0; i < size * size; i++) {
            longarr2[i] = 100L;
        }
    }


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
           sameCacheLineTest();//546ms
          //differCacheLineTest();//105ms

    }


    public static void sameCacheLineTest() throws BrokenBarrierException, InterruptedException {
        LocalTime startTime = LocalTime.now();
        Thread t1=new Thread(()-> {
            for (int j = 0; j < count; j++) {
                    longarr1[0] = 200L;
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()-> {
            for (int j = 0; j < count; j++) {
                longarr1[1] = 200L;
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

        cyclicBarrier.await();
        LocalTime endTime = LocalTime.now();
        System.out.println("同一cacheLine修改耗时" + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }

    public static void differCacheLineTest() throws BrokenBarrierException, InterruptedException {
        LocalTime startTime = LocalTime.now();
        Thread t1=new Thread(()-> {
            for (int j = 0; j < count; j++) {
                longarr2[0] = 200L;
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()-> {
            for (int j = 0; j < count; j++) {
                longarr2[8] = 200L;
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        cyclicBarrier.await();
        LocalTime endTime = LocalTime.now();
        System.out.println("不同cacheLine修改耗时" + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}
