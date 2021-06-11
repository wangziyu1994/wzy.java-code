package com.wangziyu.proxystudy.abstractmodel;

public class TargetObject implements AInterface,BInterface{
    @Override
    public String function1(String str) {
        System.out.println("targetA方法");
        return "A";
    }

    @Override
    public String function2(String str) {
        System.out.println("targetB方法");
        return "B";
    }
}
