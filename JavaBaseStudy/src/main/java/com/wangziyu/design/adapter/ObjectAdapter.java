package com.wangziyu.design.adapter;

public class ObjectAdapter implements Target{
    private Adaptee adaptee=new Adaptee();

    @Override
    public void targetMethod() {
        System.out.println("我是对象适配器重写的方法");
    }

    public Adaptee getAdaptee() {
        return adaptee;
    }

    public void setAdaptee(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
