package com.wangziyu.jdk8new.methodref;
@FunctionalInterface
public interface MyInstanceInter<A,B> {
    B newInstance(A a);
}
