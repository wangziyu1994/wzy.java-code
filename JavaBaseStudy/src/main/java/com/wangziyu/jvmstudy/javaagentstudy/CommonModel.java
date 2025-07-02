package com.wangziyu.jvmstudy.javaagentstudy;

public class CommonModel {
    private String name;
    private String name1;
    private String name2;
    private int id;
    private int id1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonModel(String name) {
        this.name = name;
    }

    public CommonModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public CommonModel() {
    }
}
