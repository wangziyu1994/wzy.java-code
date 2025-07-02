package com.wangziyu.mybatis.cache;

public interface WzyMapper {
    Person doPersonQry1(int id);
    Person doPersonQry2(int id);
    int doPersonUpdate(int id);
}
