package com.springsource.custom;

public class WzyAttrJavaBean {
	private String wzyAttrJavaBeanValue;

	public String getWzyAttrJavaBeanValue() {
		return wzyAttrJavaBeanValue;
	}

	public void setWzyAttrJavaBeanValue(String wzyAttrJavaBeanValue) {
		this.wzyAttrJavaBeanValue = wzyAttrJavaBeanValue;
	}


	@Override
	public String toString() {
		return "WzyAttrJavaBean{" +
				"wzyAttrJavaBeanValue='" + wzyAttrJavaBeanValue + '\'' +
				'}';
	}
}
