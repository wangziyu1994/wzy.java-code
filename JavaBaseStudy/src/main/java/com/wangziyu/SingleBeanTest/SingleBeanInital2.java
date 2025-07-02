package com.wangziyu.SingleBeanTest;

/**
 * 饿汉式单例模式
 * 单例模式分为懒汉式和饿汉式，懒汉式是在调用时创建对象，需要注意线程安全和性能优化，饿汉式是在程序加载时就创建对象，需要时直接调用。
 * 在开发时如果对于内存的要求特别高，使用懒汉式，在需要时才创建，如果对内存要求不高使用饿汉式，饿汉式简单不易出错，而且没有并发安全和性能问题。
 */
public class SingleBeanInital2 {
    private static final SingleBeanInital2  singleBeanInital2=new SingleBeanInital2();

    private SingleBeanInital2(){

    }

public SingleBeanInital2 getSingleBeanInital2(){
        return  singleBeanInital2;
}
}
