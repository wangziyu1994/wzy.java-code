package com.wangziyu.mybatis.parammap;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class ParamMapTest {
    public static final String configFilePath="Mybatis-testParamMap-config.xml";
    public static void main(String[] args) throws IOException {
        InputStream inputStream=getConfigFile(configFilePath);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();


        Person addPerson=new Person();


        WzyMapper wzyMapper=sqlSession.getMapper(WzyMapper.class);
        Person per1=wzyMapper.doPersonQry1(11);
       // Person per2=wzyMapper.doPersonQry2(1,"saber1",10);
       // Person per3=wzyMapper.doPersonQry3(1,"saber1",10);
        Person per4=wzyMapper.doPersonQry4(1,"saber1",10);


        sqlSession.commit();

        System.out.println(per1);
       // System.out.println(per2);
      //  System.out.println(per3);
        System.out.println(per4);
        //System.out.println(insertFlag);


    }



    public static InputStream getConfigFile(String path) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(path);
        return inputStream;
    }
}
