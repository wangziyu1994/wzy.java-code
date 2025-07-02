package com.springsource.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.lang.Nullable;

import java.beans.PropertyDescriptor;

public class WzyInstantiationBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if(beanClass==Person.class) {
			System.out.println("调用WzyInstantiationBeanPostProcessor  BeforeInstantiation方法");
			Enhancer enhancer=new Enhancer();
			return new Person(1, "小龙女");
		}
		return null;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用WzyInstantiationBeanPostProcessor  AfterInstantiation方法");
		if(bean instanceof  Person){
			Person person=(Person) bean;
			person.setName("黄蓉");
			person.setId(2);
			return person;
		}
		return null;
	}


	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {
		System.out.println("调用WzyInstantiationBeanPostProcessor  postProcessProperties方法");
		return null;
	}




}
