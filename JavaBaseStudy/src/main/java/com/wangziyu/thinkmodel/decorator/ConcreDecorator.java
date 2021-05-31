package com.wangziyu.thinkmodel.decorator;

public class ConcreDecorator extends Decorator{
    public ConcreDecorator() {
    }

    public ConcreDecorator(Component component) {
        super(component);
    }

    @Override
    public void comMethod() {
        System.out.println("我是ConcreDecorator,我将执行委托给父类Decorator");
        super.comMethod();
        concreMethod1();
        concreMethod2();
    }


    public void concreMethod1(){
        System.out.println("我是拓展方法concreMethod1");
    }

    public void concreMethod2(){
        System.out.println("我是拓展方法concreMethod2");
    }
}
