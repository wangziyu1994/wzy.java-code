package com.wangziyu.jvmstudy.javaagentstudy;

import agentstart.PreMainClass;
//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;O
import org.openjdk.jol.info.ClassLayout;

public class JavaAgentTest {
    public static void main(String[] args) {
        System.out.println(PreMainClass.getObjectSizeOf(new CommonModel()));

        System.out.println(PreMainClass.getObjectSizeOf(new CommonModel("wangziyu")));
        System.out.println(PreMainClass.getObjectSizeOf(new CommonModel("wangziyu",1)));
        System.out.println(PreMainClass.getObjectSizeOf(new Object24ByteSize()));
        Object o=new Object();
        //System.out.println(ObjectSizeCalculator.getObjectSize(o));
        System.out.println("new Object:" + ClassLayout.parseInstance(o).toPrintable());
        System.out.println(PreMainClass.getObjectSizeOf(new int[2]));
    }
}
