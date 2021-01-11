package com.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.model.HelloUser;


public interface HelloMapper {

	
	@Select(value="select s_id,s_name,start_date from students")
	@Results({
		@Result(column="s_id",property="sId"),
		@Result(column="s_name",property="userName"),
			@Result(column="start_date",property="startDate")
	})
	public List<HelloUser> selectHello();


	@Insert(value="Insert into students (s_id,s_name,start_date) values(#{sId},#{userName},#{startDate}) ")
	public int insertHello(HelloUser helloUser);
}
