package com.wangziyu.mulpthread.test;

import com.wangziyu.mulpthread.model.Person;
import org.junit.jupiter.api.Test;

public class PhaserTest {

    @Test
    public void test1() throws InterruptedException {
        Person.phaser.bulkRegister(7);
        for(int i=0;i<=4;i++){
            Thread t=new Thread(new Person("游客"+i));
            t.start();
        }

        Thread t1=new Thread(new Person("新娘"));
        Thread t2=new Thread(new Person("新郎"));
        t1.start();
        t2.start();


        Thread.sleep(10000);

    }

}
