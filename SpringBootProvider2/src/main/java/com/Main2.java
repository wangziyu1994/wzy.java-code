package com;

import com.config.ThreadLocalConfig;
import com.model.Student;
import com.model.Teacher;

public class Main2 {
    public static void main(String args[]){

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                Student s=ThreadLocalConfig.gets();
                Teacher t=ThreadLocalConfig.get();
                System.out.println(Thread.currentThread().getName()+s);
                System.out.println(Thread.currentThread().getName()+t);
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                Student s=ThreadLocalConfig.gets();
                Teacher t=ThreadLocalConfig.get();
                System.out.println(Thread.currentThread().getName()+s);
                System.out.println(Thread.currentThread().getName()+t);
            }
        });

        t1.start();
        t2.start();

        if (null instanceof Student){
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }
    }
}
