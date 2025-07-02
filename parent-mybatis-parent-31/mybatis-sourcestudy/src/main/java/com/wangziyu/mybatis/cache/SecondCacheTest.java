package com.wangziyu.mybatis.cache;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class SecondCacheTest {
    public static final String configFilePath="Mybatis-testCache-config.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession firstSqlSession;
    private SqlSession secondSqlSession;

    @Before
    public void init() throws IOException {
        InputStream inputStream=getConfigFile(configFilePath);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public  void  testFirstCache1() throws IOException {
        firstSqlSession=sqlSessionFactory.openSession();
        WzyMapper wzyMapper=firstSqlSession.getMapper(WzyMapper.class);
        Person per1=wzyMapper.doPersonQry1(1);
        Person per2=wzyMapper.doPersonQry1(2);
        firstSqlSession.commit();
        printResult(per1==per2);
    }


    @Test
    public  void  testFirstCache2() throws IOException {
        firstSqlSession=sqlSessionFactory.openSession();
        secondSqlSession=sqlSessionFactory.openSession();
        WzyMapper wzyMapper1=firstSqlSession.getMapper(WzyMapper.class);
        WzyMapper wzyMapper2=secondSqlSession.getMapper(WzyMapper.class);
        Person per1=wzyMapper1.doPersonQry1(1);
        Person per2=wzyMapper2.doPersonQry1(1);
        firstSqlSession.commit();
        printResult(per1==per2);
    }

    @Test
    public  void  testFirstCache3() throws IOException {
        firstSqlSession=sqlSessionFactory.openSession();
        WzyMapper wzyMapper1=firstSqlSession.getMapper(WzyMapper.class);
        Person per1=wzyMapper1.doPersonQry1(1);
        Person per2=wzyMapper1.doPersonQry2(1);
        firstSqlSession.commit();
        printResult(per1==per2);
    }

    @Test
    public  void  testFirstCache4() throws IOException {
        firstSqlSession=sqlSessionFactory.openSession();
        secondSqlSession=sqlSessionFactory.openSession();
        WzyMapper wzyMapper1=firstSqlSession.getMapper(WzyMapper.class);
        WzyMapper wzyMapper2=secondSqlSession.getMapper(WzyMapper.class);
        WzyMapper wzyMapper3=firstSqlSession.getMapper(WzyMapper.class);

        Person per1=wzyMapper1.doPersonQry1(11);
        System.out.println(per1);

        wzyMapper2.doPersonUpdate(11);
        secondSqlSession.commit();

        Person per2=wzyMapper3.doPersonQry1(11);
        System.out.println(per2);


        firstSqlSession.commit();


        printResult(per1==per2);
    }

    @Test
    public  void  testFirstCache5() throws IOException, InterruptedException {
        firstSqlSession=sqlSessionFactory.openSession();
        WzyMapper wzyMapper1=firstSqlSession.getMapper(WzyMapper.class);



        Person per1=wzyMapper1.doPersonQry1(11);
        System.out.println(per1);

        firstSqlSession.clearCache();
        /*wzyMapper1.doPersonUpdate(11);
        firstSqlSession.commit();*/
        /*Thread thread1=new Thread(()->{
            wzyMapper1.doPersonUpdate(11);
            firstSqlSession.commit();
        });

        thread1.start();
        thread1.join();
*/

        Person per2=wzyMapper1.doPersonQry1(11);
        System.out.println(per2);





        printResult(per1==per2);
    }


    public  void printResult(boolean flag) throws IOException {
        if(flag){
            System.out.println(String.valueOf(flag)+"使用了一级缓存");
        }else{
            System.out.println(String.valueOf(flag)+"未使用一级缓存");
        }
    }

    public  InputStream getConfigFile(String path) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(path);
        return inputStream;
    }
}
