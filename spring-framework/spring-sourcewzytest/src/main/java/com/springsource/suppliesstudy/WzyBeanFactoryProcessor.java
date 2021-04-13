package com.springsource.suppliesstudy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class WzyBeanFactoryProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition=beanFactory.getBeanDefinition("wzySupplierBean");
		GenericBeanDefinition gbd=(GenericBeanDefinition)beanDefinition;
		gbd.setInstanceSupplier(WzySupplierBean::get);
	}
}
