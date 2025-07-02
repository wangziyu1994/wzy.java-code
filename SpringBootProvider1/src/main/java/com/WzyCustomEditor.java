package com;


import java.beans.PropertyEditorSupport;

public class WzyCustomEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("开始自定义属性值转换");
        String[] convertValues=text.split("-");
        WzyCustom wzyCustom =new WzyCustom();
        wzyCustom.setHobbit(convertValues[1]);
        wzyCustom.setName(convertValues[0]);
        this.setValue(wzyCustom);
        System.out.println("自定义属性值转换完成");
    }


}
