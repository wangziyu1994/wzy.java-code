package com.wangziyu.design.proxy.dynamicproxy.jdk;

import com.wangziyu.design.proxy.MyInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationInteceptor implements InvocationHandler {
    private MyInterface target;

    public MyInvocationInteceptor(MyInterface myInterface) {
        this.target = myInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行MyInvocationInceptor方法");
        System.out.println("代理对象的类对象是"+proxy.getClass());
        System.out.println("代理对象代理的方法名是"+method.getName());
        System.out.println("开始执行dosomething方法");
        Object result=method.invoke(target,args);
        return result;
    }
}
