package com.wangziyu.superstudy.model;

public class Son extends Father{
    private String hobbit;

    public Son() {
        System.out.println("调用儿子无参构造方法");
    }

    public Son(String name,String age,String hobbit) {
        super(name,age);
        this.hobbit = hobbit;
        System.out.println("调用儿子有参构造方法");
    }

    public String getHobbit() {
        return hobbit;
    }

    public void setHobbit(String hobbit) {
        this.hobbit = hobbit;
    }

    @Override
    public String toString() {
        return "Son{" +
                "hobbit='" + hobbit + '\'' +
                '}';
    }
}
