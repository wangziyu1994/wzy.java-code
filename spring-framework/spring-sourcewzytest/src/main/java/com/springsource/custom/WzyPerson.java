package com.springsource.custom;

public class WzyPerson {
	private String id;
	private WzyPropertyJavaBean wzyPropertyJavaBean;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WzyPropertyJavaBean getWzyPropertyJavaBean() {
		return wzyPropertyJavaBean;
	}

	public void setWzyPropertyJavaBean(WzyPropertyJavaBean wzyPropertyJavaBean) {
		this.wzyPropertyJavaBean = wzyPropertyJavaBean;
	}

	@Override
	public String toString() {
		return "WzyPerson{" +
				"id='" + id + '\'' +
				", wzyPropertyJavaBean=" + wzyPropertyJavaBean +
				'}';
	}
}
