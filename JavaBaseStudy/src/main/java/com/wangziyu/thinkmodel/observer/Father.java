package com.wangziyu.thinkmodel.observer;

public class Father implements WzyObserver{
    @Override
    public void docatchTarget(CryEvent cryEvent) {
        System.out.println("我是父亲,捕捉到孩子哭事件"+this.getClass());
    }
}
