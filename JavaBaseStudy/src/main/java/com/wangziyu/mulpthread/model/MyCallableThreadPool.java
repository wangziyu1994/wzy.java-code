package com.wangziyu.mulpthread.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class MyCallableThreadPool implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;

    public MyCallableThreadPool(File directory, String keyword,ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool=pool;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    MyCallableThreadPool myCallableThreadPool = new MyCallableThreadPool(file, keyword,pool);
                    Future<Integer> result=pool.submit(myCallableThreadPool);
                    results.add(result);
                } else {
                    if(search(file))count++;
                }

                for (Future<Integer> result : results) {
                    try {
                        result.get();
                        count += result.get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (InterruptedException e) {

        }
        return count;
    }


    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }
        } catch (IOException e) {
            return false;
        }
    }
}
