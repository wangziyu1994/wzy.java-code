package com.springsource.applypropertyvalue;

import java.util.List;
import java.util.Map;

public class Person {
	private String name;

	private List<Address> addressList;

	private Map<String,Object> PMaps;

	private Address noPropertyAddress;

	public Address getNoPropertyAddress() {
		return noPropertyAddress;
	}

	public void setNoPropertyAddress(Address noPropertyAddress) {
		this.noPropertyAddress = noPropertyAddress;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Map<String, Object> getPMaps() {
		return PMaps;
	}

	public void setPMaps(Map<String, Object> PMaps) {
		this.PMaps = PMaps;
	}
}
