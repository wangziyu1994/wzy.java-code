package com.wangziyu.thinkmodel.adapter;

public class ClassAdapter extends Adaptee implements  Target{
    @Override
    public void targetMethod() {
        System.out.println("我是target的方法");
    }


    public void adapteeMethod(){
        System.out.println("我是类适配器重写的方法");
    }
}
