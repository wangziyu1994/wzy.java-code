package com;

public class Person {
    private String name;
    private WzyCustom wzyCustom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WzyCustom getWzyCustom() {
        return wzyCustom;
    }

    public void setWzyCustom(WzyCustom wzyCustom) {
        this.wzyCustom = wzyCustom;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", wzyCustom=" + wzyCustom +
                '}';
    }
}
