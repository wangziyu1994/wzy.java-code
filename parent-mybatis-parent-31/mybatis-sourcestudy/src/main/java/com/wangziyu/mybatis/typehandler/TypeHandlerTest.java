package com.wangziyu.mybatis.typehandler;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TypeHandlerTest {
    public static final String configFilePath="Mybatis-testTypeHandler-config.xml";
    public static final String mapperNameSpace="com.wangziyu.mybatis.typehandler.WzyMapper.";
    public static final String insertID="doInsertPerson";
    public static final String updateID="doUpdatePerson";
    public static final String selectID="doPersonQry";
    public static void main(String[] args) throws IOException {
        InputStream inputStream=getConfigFile(configFilePath);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();


        Person addPerson=new Person(1,"111111111");


        WzyMapper wzyMapper=sqlSession.getMapper(WzyMapper.class);
        Person per=wzyMapper.doPersonQry(11);

       // int insertFlag=wzyMapper.doInsertPerson(addPerson);
        sqlSession.commit();

        System.out.println(per);
        //System.out.println(insertFlag);


    }



    public static InputStream getConfigFile(String path) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(path);
        return inputStream;
    }
}
