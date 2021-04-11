package com.wangziyu.jvmstudy.classloaderstudy;

public class ClassLoadingProcdureTest {
    public static void main(String[] args) {
        System.out.println(MyClass1.var1);//3
        System.out.println(MyClass2.var1);//2
    }


    static class MyClass1{
        private static int var1=2;
        private static MyClass1 myClass1=new MyClass1();

        public MyClass1() {
            var1++;
        }
    }

    static class MyClass2{
        private static MyClass2 myClass2=new MyClass2();
        private static int var1=2;
        public MyClass2() {
            var1++;
        }
    }


}
