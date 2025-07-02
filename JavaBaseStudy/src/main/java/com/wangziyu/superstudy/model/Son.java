package com.wangziyu.superstudy.model;

public class Son extends Father{
    private String hobbit;
    private String age="我是子类的age";

    public Son() {
        System.out.println("调用儿子无参构造方法");
    }

    public Son(String name){
        System.out.println("我是子类一个参数的构造器");
    }

    public Son(String name,String age,String hobbit) {
        super(name,age);
        this.hobbit = hobbit;
        System.out.println("调用儿子有参构造方法");
    }

    public void common(){
        System.out.println("我是子类common方法");
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
                ", age='" + age + '\'' +
                '}';
    }
}
