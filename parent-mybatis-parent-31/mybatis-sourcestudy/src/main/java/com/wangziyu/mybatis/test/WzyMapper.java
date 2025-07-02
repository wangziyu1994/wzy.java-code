package com.wangziyu.mybatis.test;



public interface WzyMapper {
    Person doPersonQry(int id);
    int doInsertPerson(Person person);
}
