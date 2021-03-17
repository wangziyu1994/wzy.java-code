package com.springsource.custom;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.beans.propertyeditors.*;
import org.springframework.core.io.ContextResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceEditor;
import org.springframework.core.io.support.ResourceArrayPropertyEditor;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

public class WzyPropertyEditorRegister implements PropertyEditorRegistrar {

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		System.out.println("WzyPropertyEditorRegister开始注册自定义属性编辑器WzyPropertyEditor");
		WzyPropertyEditor wzyPropertyEditor=new WzyPropertyEditor();
		registry.registerCustomEditor(WzyPropertyJavaBean.class,wzyPropertyEditor);
	}
}
