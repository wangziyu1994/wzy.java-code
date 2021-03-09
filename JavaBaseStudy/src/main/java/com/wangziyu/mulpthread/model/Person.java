package com.wangziyu.mulpthread.model;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Person implements Runnable{
    String name;
    static Random r = new Random();
    int time=2;
    public static MyPhaser phaser = new MyPhaser();

    public Person(String name) {
        this.name = name;
    }

    public void arrive() {

        milliSleep(r.nextInt(time));
        System.out.printf("%s 到达现场！\n", name);
        phaser.arriveAndAwaitAdvance();
    }

    public void eat() {
        milliSleep(r.nextInt(time));
        System.out.printf("%s 吃完!\n", name);
        phaser.arriveAndAwaitAdvance();
    }

    public void leave() {
        milliSleep(r.nextInt(time));
        System.out.printf("%s 离开！\n", name);


        phaser.arriveAndAwaitAdvance();
    }

    private void hug() {
        if(name.equals("新郎") || name.equals("新娘")) {
            milliSleep(r.nextInt(time));
            System.out.printf("%s 洞房！\n", name);
            phaser.arriveAndAwaitAdvance();
        } else {
            phaser.arriveAndDeregister();
            //phaser.register()
        }
    }

    @Override
    public void run() {
        arrive();


        eat();


        leave();


        hug();

    }


    static void milliSleep(int milli) {
        try {
            TimeUnit.SECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
