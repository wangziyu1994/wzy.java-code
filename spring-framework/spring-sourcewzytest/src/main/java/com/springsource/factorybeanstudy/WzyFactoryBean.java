package com.springsource.factorybeanstudy;

import org.springframework.beans.factory.FactoryBean;

public class WzyFactoryBean implements FactoryBean<Person> {
	@Override
	public Person getObject() throws Exception {
		return new Person(1,"FactoryBean创建出来的Bean");
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
