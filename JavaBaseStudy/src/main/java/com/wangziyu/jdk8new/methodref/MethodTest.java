package com.wangziyu.jdk8new.methodref;

import org.junit.jupiter.api.Test;

public class MethodTest {
    @Test
    public void test1() {
        MyFunctionInter<String, String> myFunctionInter1 = new MyFunctionInter<String, String>() {
            @Override
            public String function(String s) {
                System.out.println(s);
                return s;
            }
        };


   MyFunctionInter<String, String> myFunctionInter2=(a)->{
       System.out.println(a);
       return a;
   };

        MyFunctionInter<Integer, String> myFunctionInter3=AClass::getStr;


        AClass aClass=new AClass();
        MyFunctionInter<String, String> myFunctionInter4=aClass::getInsStr;

        myFunctionInter1.function("我是匿名内部类使用");
        myFunctionInter2.function("我是lambda使用");
        myFunctionInter3.function(232323);
        myFunctionInter4.function("我是方法使用");



    }


    @Test
    public void test2(){
        MyInstanceInter<String,AClass> myInstanceInter=AClass::new;
        AClass aClass=myInstanceInter.newInstance("构造方法引用");
        System.out.println(aClass.s1);


    }

    @Test
    public void test3(){
        AClass aClass=new AClass();
        MyFunctionInter<String,String> myFunctionInter=AClass::getStr;
        MyFunctionInter<String,String> myFunctionInter1=aClass::getInsStr;
        function(myFunctionInter,"参数方法引用");
        function(myFunctionInter1,"参数方法引用");
    }


    @Test
    public void test4(){
        BClass bClass=new BClass();
        MyObjectInter<BClass,String> myObjectInter=(a,s)->{
            System.out.println("paramType  "+a.getClass().getName());
            return "MyObjectInter";
        };

        MyObjectInter<BClass,String> myObjectInter1=bClass::BMethod;


        MyObjectInter<BClass,String> myObjectInter2=BClass::BMethod;

        bClass.receiveFunctionMethod(myObjectInter,"lambda表达式");
        bClass.receiveFunctionMethod(myObjectInter1,"普通实例方法表达式");
        bClass.receiveFunctionMethod(myObjectInter2,"任意对象表达式");

    }



    public void function(MyFunctionInter<String,String> myFunctionInter,String s){
        String res=myFunctionInter.function(s);
        System.out.println(res);
    }


}
