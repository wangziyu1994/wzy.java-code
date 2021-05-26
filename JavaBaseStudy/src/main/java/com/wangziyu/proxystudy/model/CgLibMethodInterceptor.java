package com.wangziyu.proxystudy.model;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行之前");
        /*for(Object ob:objects){
            System.out.println(ob);
        }*/
        System.out.println(method.getName());
        System.out.println(methodProxy.getSuperName());
        System.out.println("执行代理对象实现方法");
       // method.invoke(o,objects);
        System.out.println("方法执行之后");
        return "Cglib执行结果";
    }
}
