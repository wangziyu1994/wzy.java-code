package com.wangziyu.design.decorator;

public abstract  class Decorator implements  Component{
    private  Component component;

    public Decorator() {
    }

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void comMethod() {
        System.out.println("我是Decorator,我将执行委托给Component具体的子类");
        component.comMethod();
    }
}
