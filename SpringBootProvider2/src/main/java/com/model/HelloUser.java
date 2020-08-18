package com.model;

import java.io.Serializable;

public class HelloUser implements Serializable {
	private Integer sId;
	private String name;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloUser{" +
				"sId=" + sId +
				", name='" + name + '\'' +
				'}';
	}
}


