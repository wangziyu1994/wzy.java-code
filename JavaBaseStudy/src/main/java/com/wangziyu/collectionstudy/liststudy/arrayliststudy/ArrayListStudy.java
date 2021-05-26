package com.wangziyu.collectionstudy.liststudy.arrayliststudy;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStudy {
    private static final int size=15;
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        for(int i=0;i<Integer.MAX_VALUE-1;i++) {
            list.add("1");
        }
    }
}
