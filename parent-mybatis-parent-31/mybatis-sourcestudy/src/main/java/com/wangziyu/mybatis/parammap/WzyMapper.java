package com.wangziyu.mybatis.parammap;

import org.apache.ibatis.annotations.Param;

public interface WzyMapper {
    Person doPersonQry1(int id);
    Person doPersonQry2(int id,String name,int age);
    Person doPersonQry3(@Param(value = "ID") int  id, @Param(value = "NAME") String name, @Param(value = "AGE") int age);
    Person doPersonQry4(int id,String name,int age);
}
