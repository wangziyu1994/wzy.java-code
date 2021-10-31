package com.wangziyu.design.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChildTarget implements Runnable {
    private List<WzyObserver> wzyObserverList=new ArrayList<>();

    @Override
    public void run() {
        System.out.println("开始注册观察这对象");
        wzyObserverList.add(new Father());
        wzyObserverList.add(new Mother());
        System.out.println("注册观察这对象完成");
        CryEvent cryEvent=new CryEvent(new Date(),"jai");
        System.out.println("孩子发生哭事件了"+this.getClass()+"  "+cryEvent.getClass());
        for(WzyObserver wzyObserver:wzyObserverList){
            wzyObserver.docatchTarget(cryEvent);
        }


    }
}
