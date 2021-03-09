package com.wangziyu.thinkmodel.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Thread thread=new Thread(new ChildTarget());
        thread.start();
    }
}
