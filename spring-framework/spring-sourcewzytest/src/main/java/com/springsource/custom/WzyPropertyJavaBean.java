package com.springsource.custom;

public class WzyPropertyJavaBean {
	private String name;
	private String hobbit;
	private String lover;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobbit() {
		return hobbit;
	}

	public void setHobbit(String hobbit) {
		this.hobbit = hobbit;
	}

	public String getLover() {
		return lover;
	}

	public void setLover(String lover) {
		this.lover = lover;
	}

	@Override
	public String toString() {
		return "WzyPropertyJavaBean{" +
				"name='" + name + '\'' +
				", hobbit='" + hobbit + '\'' +
				", lover='" + lover + '\'' +
				'}';
	}
}
