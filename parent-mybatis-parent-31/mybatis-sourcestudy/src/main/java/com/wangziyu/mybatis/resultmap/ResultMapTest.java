package com.wangziyu.mybatis.resultmap;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class ResultMapTest {
    public static final String configFilePath="Mybatis-testResultMap-config.xml";
    public static void main(String[] args) throws IOException {
        InputStream inputStream=getConfigFile(configFilePath);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();




        WzyMapper wzyMapper=sqlSession.getMapper(WzyMapper.class);
       // Person per1=wzyMapper.doPersonQry1(1);
        Person per2=wzyMapper.doPersonQry2(1);
        Hobbit hobbit=wzyMapper.doHobbitQry(1);

        sqlSession.commit();

       // System.out.println(per1);
        System.out.println(hobbit);
        System.out.println(per2);




    }



    public static InputStream getConfigFile(String path) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(path);
        return inputStream;
    }
}
