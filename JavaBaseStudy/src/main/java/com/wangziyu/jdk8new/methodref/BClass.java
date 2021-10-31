package com.wangziyu.jdk8new.methodref;

public class BClass<A> {

    public void receiveFunctionMethod(MyObjectInter<BClass,String> myFunctionInter,String s){
        String res=myFunctionInter.doSomething(this,s);
        System.out.println(res);
    }



    public String BMethod(BClass b,String s){
        System.out.println(s);
        return "我是B的普通实例方法";
    }


    public String BMethod(String s){
        System.out.println(s);
        return "我是B少一个参数普通实例方法";
    }
}
