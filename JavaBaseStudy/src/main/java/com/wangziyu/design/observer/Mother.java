package com.wangziyu.design.observer;

public class Mother implements WzyObserver{
    @Override
    public void docatchTarget(CryEvent cryEvent) {
        System.out.println("我是母亲,捕捉到孩子哭事件"+this.getClass());
    }
}
