package com.wangziyu.rpcstudy.connectconfig;

import com.wangziyu.rpcstudy.service.Order;
import com.wangziyu.rpcstudy.serviceimpl.OrderService;

import java.util.concurrent.ConcurrentHashMap;

public class ServiceDispatcher {
public static ConcurrentHashMap<String,Object> serviceMap=new ConcurrentHashMap<>();

public  void registerService(Object service){
    if(service instanceof OrderService){
        OrderService order=(OrderService)service;
        System.out.println("注册服务"+"["+order.getName()+"]成功");
        serviceMap.putIfAbsent(order.getName(),service);
    }

}


public  static void removeService(String name){
    serviceMap.remove(name);
}


    public static boolean existService(String name){
        return  serviceMap.containsKey(name);
    }


    public static Object getService(String name){
        return  serviceMap.get(name);
    }
}
