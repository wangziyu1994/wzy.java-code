package com.wangziyu.mulpthread.test;

import com.wangziyu.mulpthread.model.MyCallable;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyCallableTest {
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in))
        {
            System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();
            MyCallable myCallable = new MyCallable(new File(directory), keyword);
            FutureTask<Integer> task=new FutureTask<>(myCallable);
            Thread t=new Thread(task);
            t.start();
            try{
                    Thread.sleep(5000);
                    System.out.println(task.get() + " matching files.");
            }
            catch (ExecutionException e){
                e.printStackTrace();
            }
        }
        catch(InterruptedException e){

        }

        }
}
