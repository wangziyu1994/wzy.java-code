package com.wangziyu.jdk8new.methodref;

public class AClass {

    public String s1;

    public AClass() {
    }

    public AClass(String s) {
        System.out.println("我是Aclass构造方法 str  str");
        this.s1=s;
    }

    public static String getStr(String s){
        System.out.println("我是Aclass普通静态方法 str  str");
        return s;
    }


    public static String getStr(Integer s){
        System.out.println("我是Aclass普通静态方法  int str");
        return String.valueOf(s);
    }

    public static void getStrTwo(Integer s){
        System.out.println("我是Aclass普通静态方法  int void");
    }


    public  String getInsStr(String s){
        System.out.println("我是Aclass普通实例方法 str  str");
        return s;
    }


    public  void getInsStrTwo(Integer s){
        System.out.println("我是Aclass普通实例方法  int void");
    }
}
