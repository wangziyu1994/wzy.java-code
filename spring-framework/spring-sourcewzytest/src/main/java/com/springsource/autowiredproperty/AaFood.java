package com.springsource.autowiredproperty;

import org.springframework.stereotype.Component;

@Component
public class AaFood {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
