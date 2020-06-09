package com.model;

import java.io.Serializable;
import java.util.Date;

public class HelloUser implements Serializable{
private Integer sId;
private String userName;
private Date startDate;
public Integer getsId() {
	return sId;
}
public void setsId(Integer sId) {
	this.sId = sId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "HelloUser{" +
				"sId=" + sId +
				", userName='" + userName + '\'' +
				", startDate=" + startDate +
				'}';
	}
}
