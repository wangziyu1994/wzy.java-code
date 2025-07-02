package com.springsource.custom;



import java.beans.PropertyEditorSupport;

public class WzyPropertyEditor extends PropertyEditorSupport {


	public void setAsText(String text) throws java.lang.IllegalArgumentException {
		System.out.println("开始进入自定义属性编辑器WzyPropertyEditor");
		String[] strArr=text.split("-");
		WzyPropertyJavaBean wzyPropertyJavaBean= new WzyPropertyJavaBean();
		wzyPropertyJavaBean.setName(strArr[0]);
		wzyPropertyJavaBean.setHobbit(strArr[1]);
		wzyPropertyJavaBean.setLover(strArr[2]);
			setValue(wzyPropertyJavaBean);
		}
	}
