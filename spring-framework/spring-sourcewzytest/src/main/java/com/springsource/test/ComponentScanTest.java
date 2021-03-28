package com.springsource.test;


import com.springsource.model.ControllerModel;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ComponentScanTest {


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Set<BeanDefinition>  candiates=new HashSet<>();
		MetadataReaderFactory metadataReaderFactory=new SimpleMetadataReaderFactory();
		ResourcePatternResolver resourcePatternResolver=new PathMatchingResourcePatternResolver();
		Resource[] resources=resourcePatternResolver.getResources("classpath*:com\\springsource\\model\\*");
		for(Resource resource:resources){
			MetadataReader metadataReader=metadataReaderFactory.getMetadataReader(resource);
			ScannedGenericBeanDefinition sbd=new ScannedGenericBeanDefinition(metadataReader);
			sbd.setResource(resource);
			sbd.setSource(resource);
			candiates.add(sbd);
		}

		for(BeanDefinition sbd:candiates){
			String classname=sbd.getBeanClassName();
			Configuration configuration=Class.forName(classname).getAnnotation(Configuration.class);
			Controller c=Class.forName(classname).getAnnotation(Controller.class);
			Service s=Class.forName(classname).getAnnotation(Service.class);
			Component p=Class.forName(classname).getAnnotation(Component.class);
			Import i=Class.forName(classname).getAnnotation(Import.class);
			if(c!=null||s!=null||p!=null){
				System.out.println(classname);
			}
			if(s!=null){
				String servicevalue=s.value();
					System.out.println("注解的value:"+servicevalue);
			}
		}



	}
}
