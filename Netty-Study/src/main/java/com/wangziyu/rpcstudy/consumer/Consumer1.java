package com.wangziyu.rpcstudy.consumer;

import com.wangziyu.rpcstudy.proxy.MyInvocationHandler;
import com.wangziyu.rpcstudy.service.Order;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;

public class Consumer1 {
    public static final String localhost="localhost";
    public static final String remotehost="192.168.147.129";
    public static final int port=1200;
    public static final int count=200;

    public static void main(String[] args) {
          Class<Order> target=Order.class;

          for(int i=0;i<count;i++) {
              new Thread(()->{
                  Order order1 = getProxyObject(target);
                 /* Order order2 = getProxyObject(target);
                  Order order3 = getProxyObject(target);
                  Order order4 = getProxyObject(target);*/
                  order1.doOrder();
                 /* order2.doOrder();
                  order3.doOrder();
                  order4.doOrder();*/
              }).start();

          }
    }


    public static <T>T getProxyObject(Class<T> target){
        InvocationHandler invocationHandler=new MyInvocationHandler(target,new InetSocketAddress(localhost,port));
        ClassLoader classLoader= Consumer1.class.getClassLoader();
        Class<T>[] interfaces=new Class[]{target};
       T t= (T)Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
       return t;
    }

}
