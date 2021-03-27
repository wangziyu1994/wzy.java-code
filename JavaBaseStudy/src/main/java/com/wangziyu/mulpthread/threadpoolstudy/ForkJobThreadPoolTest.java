package com.wangziyu.mulpthread.threadpoolstudy;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class ForkJobThreadPoolTest {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 100;
    static Random r = new Random();

    static {
        for (int i = 0; i <= nums.length - 1; i++) {
            nums[i] = 1;
        }
    }

    public static void main(String[] args) {
        LocalTime startTime = LocalTime.now();
        //System.out.println(Arrays.stream(nums).sum());//累计求和 14ms  1000000
        forkJobTest();                                 //分段求和        1000000
        LocalTime endTime = LocalTime.now();
        System.out.println(ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }

    public static void forkJobTest() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CalculateTask calculateTask=new CalculateTask(Thread.currentThread().getName(),0,nums.length);
        forkJoinPool.submit(calculateTask);
        Long result=calculateTask.join();
        System.out.println("总值为"+result);
    }

    static class CalculateTask extends RecursiveTask<Long> {
        private int start;
        private int end;
        private String name;

        public CalculateTask(String name, int start, int end) {
            this.start = start;
            this.end = end;
            this.name = name;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected Long compute() {
            int gap = this.end - this.start;
            if (gap > MAX_NUM) {
                //System.out.println("当前"+start+"--->"+end+"计算距离" + gap + "继续分段");
                gap = gap / 2;
                CalculateTask calculateTask1 = new CalculateTask(Thread.currentThread().getName(), this.start, this.start + gap);
                CalculateTask calculateTask2 = new CalculateTask(Thread.currentThread().getName(), this.start+gap, this.end);
                calculateTask1.fork();
                calculateTask2.fork();
                return calculateTask1.join()+calculateTask2.join();
            } else {

                Long sum=0L;
                for(int i=start;i<end;i++){
                    sum+=nums[i];
                }
                //System.out.println("当前"+start+"--->"+end+"计算距离" + gap + "停止分段,Sum"+sum);
                return sum;
            }
        }
    }

}
