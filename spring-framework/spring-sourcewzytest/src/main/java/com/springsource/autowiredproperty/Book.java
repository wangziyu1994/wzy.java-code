package com.springsource.autowiredproperty;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Book {
	private int bookid;
	private String bookname;

	private Address address;


	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public void setdsfasdfAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookid=" + bookid +
				", bookname='" + bookname + '\'' +
				", address=" + address +
				'}';
	}
}
