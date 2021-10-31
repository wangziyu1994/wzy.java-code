package com.wangziyu.design.adapter;

import org.junit.jupiter.api.Test;

public class AdapterTest {
    /**
     * 类适配器模式
     */
    @Test
    public void test1() {
        ClassAdapter classAdapter = new ClassAdapter();
        classAdapter.adapteeMethod();
        classAdapter.targetMethod();
    }

    /**
     * 对象适配器模式
     */
    @Test
    public void test2() {
        ObjectAdapter objectAdapter = new ObjectAdapter();
        objectAdapter.getAdaptee().adapteeMethod();
        objectAdapter.targetMethod();
    }


    /**
     * 接口适配器模式
     */
    @Test
    public void test3() {
        InterfaceAdapter interfaceAdapter = new InterfaceAdapter();
        interfaceAdapter.adapteeMethod();
        interfaceAdapter.targetMethod();
    }
}
