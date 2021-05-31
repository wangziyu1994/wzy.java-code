package com.wangziyu.thinkmodel.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        System.out.println("拓展前:-------------");
        Component component = new ConcreComponent();
        component.comMethod();
        System.out.println("拓展后:-------------");
        Decorator decorator = new ConcreDecorator(component);
        decorator.comMethod();
    }
}
