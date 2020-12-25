package com.wangziyu.proxystudy.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandle implements InvocationHandler {
    private Object target;
    public TraceHandle(Object t){
        target=t;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print(" "+method.getName()+"(");
        if(args!=null){
            for (int i=0;i<=args.length-1;i++){
                System.out.print(args[i]);
                if(i<args.length-1)System.out.print(",");
            }
        }
        System.out.print(")");
        System.out.println(" ");
        return method.invoke(target,args);
    }
}
