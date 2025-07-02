package com.springsource.custom;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class WzyNameSpaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("wzycustomElement", new WzyElementParser());
	}
}
