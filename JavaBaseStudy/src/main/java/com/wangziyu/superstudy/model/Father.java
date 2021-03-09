package com.wangziyu.superstudy.model;

public class Father extends GrandFather {
    private String age;

    public Father( ) {
      System.out.println("调用父亲无参构造方法");
    }

    public Father(String name,String age) {
        //super(name);
        this(name);
        System.out.println("调用父亲有参构造方法");
        this.age=age;
        this.common();
    }


    public Father(String name){
       System.out.println("我是父类一个参数的构造器");
    }


    public void common(){
        System.out.println("我是父类common方法");
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Father{" +
                "age='" + age + '\'' +
                '}';
    }
}
