package com.wangziyu.mybatis.resultmap;

public class Hobbit {
    private int h_id;
    private String h_name;

    public Hobbit() {
    }

    public Hobbit(int h_id, String h_name) {
        this.h_id = h_id;
        this.h_name = h_name;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    @Override
    public String toString() {
        return "Hobbit{" +
                "h_id=" + h_id +
                ", h_name='" + h_name + '\'' +
                '}';
    }
}

