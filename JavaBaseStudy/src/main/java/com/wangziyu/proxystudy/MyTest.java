package com.wangziyu.proxystudy;

import com.wangziyu.proxystudy.abstractmodel.AInterface;
import com.wangziyu.proxystudy.abstractmodel.BInterface;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyTest {
    @Test
    public void test1(){
        //类加载器
        ClassLoader classLoader=this.getClass().getClassLoader();
        //
        InvocationHandler invocationHandler=new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("进入代理对象的实现方法");
                return null;
            }
        };
        //需要代理类的Class对象数组
        Class[] proxyClassArray={AInterface.class, BInterface.class};
        Object obj= Proxy.newProxyInstance(classLoader,proxyClassArray,invocationHandler);
        AInterface a=(AInterface)obj;
        BInterface b=(BInterface)obj;

        a.function1("AInterface");
        b.function2("BInterface");
        System.out.println(a.getClass());
        System.out.println(obj.toString());

    }



    @Test
    public void test2() throws Exception{
       String str="は";
       System.out.println("GBK  "+str.getBytes("GBK").length);
        System.out.println("UTF-8  "+str.getBytes("UTF-8").length);
    }
}
