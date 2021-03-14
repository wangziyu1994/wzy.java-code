package com;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class WzyCustomEditorsRegisters implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        System.out.println("开始自定义属性编辑器的注册工作");
        registry.registerCustomEditor(WzyCustom.class,new WzyCustomEditor());
    }
}
