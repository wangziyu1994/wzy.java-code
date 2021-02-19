package com.wangziyu.superstudy.model;

public class Father extends GrandFather {
    private String age;

    public Father( ) {
      System.out.println("调用父亲无参构造方法");
    }

    public Father(String name,String age) {
        //super(name);
        this.age=age;
        System.out.println("调用父亲有参构造方法");
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
