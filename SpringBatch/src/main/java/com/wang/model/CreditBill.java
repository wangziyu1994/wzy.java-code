package com.wang.model;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CreditBill implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3027445174224987702L;
	private String id;
	
	@Value("${spring.nas_directory.path}")
	public  static String path;
	
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@NotBlank
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String accountID = "";    /** 银行卡账户ID */
    private String name = "";        /** 持卡人姓名 */
    private double amount = 0;        /** 消费金额 */
    private String date;            /** 消费日期 ，格式YYYY-MM-DD HH:MM:SS*/
    private String address;            /** 消费场所 **/
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CreditBill [id=" + id + ", accountID=" + accountID + ", name=" + name + ", amount=" + amount + ", date="
				+ date + ", address=" + address + "]";
	}
	
    
    
}
