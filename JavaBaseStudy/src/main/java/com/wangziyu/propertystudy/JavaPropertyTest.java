package com.wangziyu.propertystudy;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class JavaPropertyTest {

    private final String absPropertyFile = "D:\\gitResposity-code\\JavaBaseStudy\\src\\main\\java\\com\\wangziyu\\propertystudy\\wzyproperties.properties";
    private final String clPropertyFile = "wzyproperties.properties";

    /**
     * Properties 读取properties文件
     * 利用FileInputStream 读取文件目录
     */
    @Test
    public void test1() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(absPropertyFile);
            properties.load(inputStream);
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String propKey = (String) enumeration.nextElement();
                String propValue = properties.getProperty(propKey);
                System.out.println("propKey:" + propKey + ";propValue:" + propValue);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /**
     * Properties 读取properties文件
     * 利用getResourceAsStream 读取当前class文件类路径下的文件目录   /+路径 读取classPath路径下的目录
     */
    @Test
    public void test2() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(clPropertyFile);
            properties.load(inputStream);
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String propKey = (String) enumeration.nextElement();
                String propValue = properties.getProperty(propKey);
                System.out.println("propKey:" + propKey + ";propValue:" + propValue);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
