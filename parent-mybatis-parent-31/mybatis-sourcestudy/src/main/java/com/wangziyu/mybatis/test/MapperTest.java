package com.wangziyu.mybatis.test;

import com.wangziyu.mybatis.test.WzyMapper;
import com.wangziyu.mybatis.test.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class MapperTest {
    public static final String configFilePath="Mybatis-config.xml";
    public static void main(String[] args) throws IOException {
        InputStream inputStream=getConfigFile(configFilePath);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();

        WzyMapper wzyMapper=sqlSession.getMapper(WzyMapper.class);
        Person per=wzyMapper.doPersonQry(1);
        System.out.println(per.getName().getClass());
    }



    public static InputStream getConfigFile(String path) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(path);
        return inputStream;
    }
}
