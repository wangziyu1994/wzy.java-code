package com.wangziyu.proxystudy.test;

import com.wangziyu.proxystudy.abstractmodel.AInterface;
import com.wangziyu.proxystudy.model.CgLibMethodInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Field;
import java.util.Properties;

public class CgLibProxyTest {
    public static void main(String[] args) throws Exception {
       // String dir=System.getProperty("user.dir");
       // System.out.println(dir);
        saveGeneratedCGlibProxyFiles(CgLibProxyTest.class.getClass().getResource("/").getPath());
        CgLibMethodInterceptor interceptor=new CgLibMethodInterceptor();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(AInterface.class);
        enhancer.setCallback(interceptor);
        AInterface proxy=(AInterface) enhancer.create();
        proxy.function1("aaaaa");

    }

    public static void saveGeneratedCGlibProxyFiles(String dir) throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);//dir为保存文件路径
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
    }


}
