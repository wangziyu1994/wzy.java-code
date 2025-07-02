package com.springsource.test;


import org.springframework.core.io.*;

import java.net.MalformedURLException;

/**
 * Spring框架为了更方便的获取资源，尽量弱化程序员对各个Resource接口的实现类的感知，定义了另一个ResourceLoader接口。
 * 该接口的getResource(String location)方法可以用来获取资源。它的DefaultResourceLoader实现类可以适用于所有的环境，
 * 可以返回ClassPathResource、UrlResource等。
 *ResourceLoader在进行加载资源时需要使用前缀来指定需要加载：“classpath:path”表示返回ClasspathResource，
 * “http://path”和“file:path”表示返回UrlResource资源，如果不加前缀则需要根据当前上下文来决定，
 * DefaultResourceLoader默认实现是加载classpath资源。
 */
public class SpringResourceLoaderTest {
	private static final String classpathFileName = "classpath:classPathTest.properties";
	private static final String fileUrlFileName = "file:///D:/gitResposity-code/spring-framework/spring-sourcewzytest/build/classes/java/main/com/springsource/test/classPathTest.properties";
	private static final String defaultFileName = "classPathTest.properties";

	public static void main(String[] args) {
		ResourceLoader defaultResource=new DefaultResourceLoader() ;
		classPathResourceLoaderTest(defaultResource);
		fileSystemResourceLoaderTest(defaultResource);
		urlPathResourceLoaderTest(defaultResource);
	}

	public static void classPathResourceLoaderTest(ResourceLoader resourceLoader){
		Resource resource=resourceLoader.getResource(classpathFileName);
		System.out.println("当前类路径下文件名:" + resource.getFilename());
	}


	public static void fileSystemResourceLoaderTest(ResourceLoader resourceLoader) {
		Resource resource=resourceLoader.getResource(fileUrlFileName);
		System.out.println("当前FileUrl文件夹路径下文件名:" + resource.getFilename());
	}


	public static void urlPathResourceLoaderTest(ResourceLoader resourceLoader) {
		Resource resource=resourceLoader.getResource(defaultFileName);
		System.out.println("默认路径下:" + resource.getFilename());
	}

}
