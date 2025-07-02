package com.wangziyu.design.adapter;

public class InterfaceAdapter extends Adaptee implements Target{

    @Override
    public void targetMethod() {
        System.out.println("我是接口适配器的target方法");
    }

    public void adapteeMethod(){
        System.out.println("我是接口适配器的adaptee方法");
    }
}
