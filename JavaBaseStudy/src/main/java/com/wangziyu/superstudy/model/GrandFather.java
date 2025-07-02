package com.wangziyu.superstudy.model;

public class GrandFather {
    private String name;

    public GrandFather() {
       System.out.println("调用爷爷无参构造器方法");
    }
    public GrandFather(String name) {
        System.out.println("调用爷爷有参构造器方法");
        this.common();
        this.name = name;
    }

    public void common(){
        System.out.println("我是爷爷common方法");
    }


    @Override
    public String toString() {
        return "GrandFather{" +
                "name='" + name + '\'' +
                '}';
    }
}
