package com.wangziyu.mulpthread.test;

import com.wangziyu.mulpthread.model.MyThreadQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueTest {
    private static MyThreadQueue<File> myThreadQueue = new MyThreadQueue<>(new ArrayBlockingQueue<File>(20));
    private static File DUMY = new File("");
    private static final int SEARCH_THREADS = 100;
    private static BlockingQueue<File> queue = myThreadQueue.queue;


    public static void main(String[] args) throws InterruptedException {

        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. /opt/jdkl.8.0/src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();


            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
                    queue.put(DUMY);

                } catch (InterruptedException e) {

                }
            };
            new Thread(enumerator).start();
            for (int i = 1;i<=SEARCH_THREADS;i++){
                Runnable searcher = () -> {
                    boolean done = false;
                    while (!done) {
                        File file = null;
                        try {
                            file = queue.take();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (file == DUMY) {
                            try {
                                queue.put(file);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            done = true;
                        } else {
                            try {
                                search(file, keyword);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };

                new Thread(searcher).start();
            }
        }
        Thread.sleep(5000);
    }



    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory())enumerate(file);
            else queue.put(file);
        }
    }


    public static void search(File file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword))
                System.out.printf("%s:%d:%s%n",file.getPath(), lineNumber, line);
            }
        }
    }
}
