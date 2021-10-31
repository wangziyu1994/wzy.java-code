package com.wangziyu.design.decorator;

public class ConcreComponent implements Component{
    @Override
    public void comMethod() {
        System.out.println("我是Concrecomponent实现Component的方法");
    }
}
