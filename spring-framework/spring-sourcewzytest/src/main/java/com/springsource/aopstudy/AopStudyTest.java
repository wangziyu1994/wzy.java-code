package com.springsource.aopstudy;

import com.springsource.cycledependcy.A;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.Properties;

public class AopStudyTest {
	public static void main(String[] args) throws Exception {
		saveGeneratedCGlibProxyFiles(AopStudyTest.class.getResource("/").getPath());
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("AopTest.xml");
		WzyTarget a=applicationContext.getBean(WzyTarget.class);
		a.wzytargetMethod();
	}


	public static void saveGeneratedCGlibProxyFiles(String dir) throws Exception {
		Field field = System.class.getDeclaredField("props");
		field.setAccessible(true);
		Properties props = (Properties) field.get(null);
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);//dir为保存文件路径
		props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
	}
}
