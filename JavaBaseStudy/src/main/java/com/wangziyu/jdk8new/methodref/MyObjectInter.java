package com.wangziyu.jdk8new.methodref;
@FunctionalInterface
public interface MyObjectInter<A,B> {
    B doSomething(A a,String s);
}
