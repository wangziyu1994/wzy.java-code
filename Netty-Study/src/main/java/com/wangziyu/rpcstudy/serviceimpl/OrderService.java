package com.wangziyu.rpcstudy.serviceimpl;

import com.wangziyu.rpcstudy.service.Order;

public class OrderService implements Order {
    private String name;

    public OrderService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doOrder() {
        System.out.println(Thread.currentThread().getName()+"进入服务端Order接口实现类方法");
    }
}
