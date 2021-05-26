package com.wangziyu.thinkmodel.proxy.staticproxy;


import com.wangziyu.thinkmodel.proxy.MyInterface;

public class TargetClassModel implements MyInterface {
    @Override
    public Object dosomething(Object args1, Object args2) {
        System.out.println("目标类的方法执行");
        return "targetMethod";
    }
}
