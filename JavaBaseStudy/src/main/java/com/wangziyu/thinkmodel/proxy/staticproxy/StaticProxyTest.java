package com.wangziyu.thinkmodel.proxy.staticproxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        ProxyClassModel proxyClassModel=new ProxyClassModel(new TargetClassModel());
        Object result= proxyClassModel.dosomething("args1","args2");
        System.out.println(result);
    }
}
