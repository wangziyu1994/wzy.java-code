package com.springsource.test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

public class SpringResourceTest {
	private static final String fileName = "classPathTest.properties";
	private static final String urlFilePath = "file:///D:/gitResposity-code/spring-framework/spring-sourcewzytest/build/classes/java/main/com/springsource/test/classPathTest.properties";

	public static void main(String[] args) throws MalformedURLException {
		classPathResourceTest();
		fileSystemResourceTest();
		urlPathResourceTest();
	}


	/**
	 * 获取当前类路径获取文件
	 */
	public static void classPathResourceTest() {
		Resource classPathResource = new ClassPathResource(fileName);
		System.out.println("当前类路径下文件名:" + classPathResource.getFilename());
	}


	public static void fileSystemResourceTest() {
		Resource fileSystemResource = new FileSystemResource(fileName);
		System.out.println("当前文件路径下文件名:" + fileSystemResource.getFilename());
	}


	public static void urlPathResourceTest() throws MalformedURLException {
		Resource urlPathResource = new UrlResource(urlFilePath);
		System.out.println("当前Url请求后文件名:" + urlPathResource.getFilename());
	}


	public static void servletPathResourceTest() {

	}


	public static void inputStreamResourceTest() {

	}
}
