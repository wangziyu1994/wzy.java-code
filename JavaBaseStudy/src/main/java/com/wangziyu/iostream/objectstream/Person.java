package com.wangziyu.iostream.objectstream;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 6L;
    private int id;


    private String name;

    public String getName1() {
        return name;
    }

    public void setName1(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
