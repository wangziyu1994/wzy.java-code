package com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class WzyCustom {
    private String name;
    private String hobbit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbit() {
        return hobbit;
    }

    public void setHobbit(String hobbit) {
        this.hobbit = hobbit;
    }

    @Override
    public String toString() {
        return "WzyCustom{" +
                "name='" + name + '\'' +
                ", hobbit='" + hobbit + '\'' +
                '}';
    }


}
