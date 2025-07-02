package com.springsource.autowiredproperty;

import java.util.*;

public class Person {
	private int id;
	private Integer idinteger;
	private String name;
	private int[] idarray;
	private String[]  strarray;
	private Address[] addressearray;
	private Address addressObject;
	private List<Book> bookList;
	private Set<Integer> integerSet;
	private Map<String,Object> maps;
	private Properties properties;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdinteger() {
		return idinteger;
	}

	public void setIdinteger(Integer idinteger) {
		this.idinteger = idinteger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getIdarray() {
		return idarray;
	}

	public void setIdarray(int[] idarray) {
		this.idarray = idarray;
	}

	public String[] getStrarray() {
		return strarray;
	}

	public void setStrarray(String[] strarray) {
		this.strarray = strarray;
	}

	public Address getAddressObject() {
		return addressObject;
	}

	public void setAddressObject(Address addressObject) {
		this.addressObject = addressObject;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Set<Integer> getIntegerSet() {
		return integerSet;
	}

	public void setIntegerSet(Set<Integer> integerSet) {
		this.integerSet = integerSet;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Address[] getAddressearray() {
		return addressearray;
	}

	public void setAddressearray(Address[] addressearray) {
		this.addressearray = addressearray;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", idinteger=" + idinteger +
				", name='" + name + '\'' +
				", idarray=" + Arrays.toString(idarray) +
				", strarray=" + Arrays.toString(strarray) +
				", addressearray=" + Arrays.toString(addressearray) +
				", addressObject=" + addressObject +
				", bookList=" + bookList +
				", integerSet=" + integerSet +
				", maps=" + maps +
				", properties=" + properties +
				'}';
	}
}
