package com.springsource.test;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ConfigurationAnnotationTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Set<AnnotatedBeanDefinition> candiates = new HashSet<>();
		MetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath*:com\\springsource\\annotationstudy\\configurationstudy\\*");
		for (Resource resource : resources) {
			MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
			ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader);
			sbd.setResource(resource);
			sbd.setSource(resource);
			candiates.add(sbd);
		}

		for (AnnotatedBeanDefinition abd : candiates) {
			String classname = abd.getBeanClassName();
			Configuration configuration = Class.forName(classname).getAnnotation(Configuration.class);
			if (configuration != null) {
				AnnotationMetadata annotationMetadata = abd.getMetadata();
				annotationMetadata.isAnnotated(Component.class.getName());
			}
		}

	}
}
