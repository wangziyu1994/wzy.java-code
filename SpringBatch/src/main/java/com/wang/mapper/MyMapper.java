package com.wang.mapper;

import org.apache.ibatis.annotations.Insert;

import com.wang.model.CreditBill;

public interface MyMapper {

	@Insert("Insert into credits(id,account_id,c_name,amount,s_date,address) "
			+ "values(#{id},#{accountID},#{name},#{amount},#{date},#{address})")
	public int  insertC(CreditBill c);
}
