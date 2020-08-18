package com.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.model.HelloUser;

public interface HelloMapper {

	
	@Select(value="select s_id,s_name from students")
	@Results({
		@Result(column="s_id",property="sId"),
		@Result(column="s_name",property="userName")
	})
	public List<HelloUser> selectHello();

	@Select(value="select s_id,s_name from students where s_name like  '%'#{name}'%' ")
	@Results({
			@Result(column="s_id",property="sId"),
			@Result(column="s_name",property="name")
	})
	public List<HelloUser> selectHelloLike(@Param("name") String name);
}
