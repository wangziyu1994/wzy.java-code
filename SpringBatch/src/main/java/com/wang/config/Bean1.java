package com.wang.config;

import org.springframework.stereotype.Component;

@Component
public class Bean1 {
    private String name;
    public Bean1(){
        System.out.println("初始化BEAN1开始！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "name='" + name + '\'' +
                '}';
    }
}
