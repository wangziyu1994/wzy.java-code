package com.wangziyu.mybatis.test;

import com.wangziyu.mybatis.mapper.WzyMapper;
import com.wangziyu.mybatis.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionTest {
    public static final String configFilePath="Mybatis-config.xml";
    public static final String mapperNameSpace="com.wangziyu.mybatis.mapper.WzyMapper.";
    public static final String insertID="doInsertPerson";
    public static final String updateID="doUpdatePerson";
    public static final String selectID="doPersonQry";
    public static void main(String[] args) throws IOException {
        InputStream inputStream=getConfigFile(configFilePath);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();

        Person addPerson=new Person(10,"\'caster\'");

        Person updatePerson=new Person(1,"saber1");

        Person selectPerson=new Person(1);


        int insertFlag=sqlSession.insert(mapperNameSpace+insertID,addPerson);
        int updateFlag=sqlSession.update(mapperNameSpace+updateID,updatePerson);
        Person person=sqlSession.selectOne(mapperNameSpace+selectID,selectPerson);
        sqlSession.commit();
        System.out.println(person);
        System.out.println(insertFlag);
        System.out.println(updateFlag);
    }



    public static InputStream getConfigFile(String path) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(path);
        return inputStream;
    }
}
