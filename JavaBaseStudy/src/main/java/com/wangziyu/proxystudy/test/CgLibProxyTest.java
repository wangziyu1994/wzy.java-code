package com.wangziyu.proxystudy.test;

import com.wangziyu.proxystudy.abstractmodel.AInterface;
import com.wangziyu.proxystudy.model.CgLibMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;

public class CgLibProxyTest {
    public static void main(String[] args) {
        CgLibMethodInterceptor interceptor=new CgLibMethodInterceptor();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(AInterface.class);
        enhancer.setCallback(interceptor);
        AInterface aInterface=(AInterface)enhancer.create();
        aInterface.function1("aInterface");

    }
}
