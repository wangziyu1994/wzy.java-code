package com.wangziyu.mybatis.typehandler;

public interface WzyMapper {
    Person doPersonQry(int id);
    int doInsertPerson(Person person);
}
