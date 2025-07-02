package com.wangziyu.genericstudy;

/**
 * 泛型类
 * @param <T>
 */
public class MyGenericClass<T extends Parents,B> {
    private T t1;
    private B b1;

    public MyGenericClass(){};

    public MyGenericClass(T t1,B b1){
        this.t1=t1;
        this.b1=b1;
    };

    public T getT1(){
        return  this.t1;
    }
    public B getB1(){
        return this.b1;
    }

    public void setT1(T t1){
        this.t1=t1;
    }

    public void setB1(B b1){
        this.b1=b1;
    }



}
