package com.wangziyu.jvmstudy.classloaderstudy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        getBootStrapClassLoader();
        getExtClassLoader();
        getAppClassLoader();
        getCustomClassLoader();
    }


    public static void getBootStrapClassLoader() {
        System.out.println("String的ClassLoader为" + String.class.getClassLoader());
    }

    public static void getExtClassLoader() {
        //System.out.println("DNSNameService.class的ClassLoader为" + sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
    }

    public static void getAppClassLoader() {
        System.out.println("当前类的ClassLoader为" + ClassLoaderTest.class.getClassLoader());
    }

    public static void getCustomClassLoader() throws ClassNotFoundException {
        WzyCustomClassLoader wzyCustomClassLoader = new WzyCustomClassLoader();
        Class<?> targetClass = wzyCustomClassLoader.loadClass("WzyClassModelOuter");
        System.out.println(targetClass + "的ClassLoader是:" + targetClass.getClassLoader());

        Class<?> targetClass1 = wzyCustomClassLoader.loadClass("WzyClassModel");
        System.out.println(targetClass1 + "的ClassLoader是:" + targetClass1.getClassLoader());
    }

    /**
     * 自定义类加载器,不打破双亲委派机制
     */
    static class WzyCustomClassLoader extends ClassLoader {
        private static final String path = "D:/gitResposity-code/WzyClassPathDir/";

        /**
         * 重写findClass方法自定义寻找类,加载类的方法
         *
         * @param name
         * @return
         * @throws ClassNotFoundException
         */
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            name = name.concat(".class");
            System.out.println("自定义加载器开始寻找类" + name);
            File f = new File(path + name);
            System.out.println(name + "寻找结果:" + f.exists());
            name = name.replace(".class", "");
            System.out.println("类的全限定名称" + name);
            Class<?> result = null;
            try {
                FileInputStream input = new FileInputStream(f);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int pos = 0;
                while ((pos = input.read()) != -1) {
                    baos.write(pos);
                }
                byte[] bytes = baos.toByteArray();
                baos.close();
                input.close();
                result = super.defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result == null) {
                throw new ClassNotFoundException("WzyCustomClassLoader为加载到" + name);
            }
            return result;

        }
    }

}

