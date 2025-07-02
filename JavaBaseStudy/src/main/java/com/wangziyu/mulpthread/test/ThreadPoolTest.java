package com.wangziyu.mulpthread.test;
import com.wangziyu.mulpthread.model.MyCallableThreadPool;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();
            ExecutorService pool = Executors.newCachedThreadPool();
            MyCallableThreadPool myCallableThreadPool = new MyCallableThreadPool(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(myCallableThreadPool);
            try {
                System.out.println(result.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

            }
            pool.shutdown();
            int largePoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("the largestPoolSize=" + largePoolSize);
        }
    }
}
