package com.wangziyu.referencestudy;

import java.util.Arrays;

public class MyObject {
    private String objectName;
    private byte[] innerArr;

    public MyObject() {
    }

    public MyObject(String objectName) {
        this.objectName = objectName;
    }

    public MyObject(String objectName, byte[] innerArr) {
        this.objectName = objectName;
        this.innerArr = innerArr;
    }


    public void finalize(){
        System.out.println("GC 开始回收MyObject");
    }
}
