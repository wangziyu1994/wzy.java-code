package com.wangziyu.design.proxy.staticproxy;

import com.wangziyu.design.proxy.MyInterface;

public class ProxyClassModel implements MyInterface {
    private TargetClassModel targetClassModel;

    public ProxyClassModel(TargetClassModel targetClassModel) {
        this.targetClassModel = targetClassModel;
    }

    @Override
    public Object dosomething(Object args1, Object args2) {
        System.out.println("Proxy类方法执行");
        return targetClassModel.dosomething(args1,args2);
    }
}
