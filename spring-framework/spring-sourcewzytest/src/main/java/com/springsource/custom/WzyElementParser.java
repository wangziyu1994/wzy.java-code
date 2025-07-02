package com.springsource.custom;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class WzyElementParser extends AbstractSingleBeanDefinitionParser {
	protected Class<?> getBeanClass(Element element) {
		System.out.println("自定义属性值类型返回WzyAttrJavaBean");
		return WzyAttrJavaBean.class ;
	}

	/**
	 * 重写父类方法自动生成bean标识
	 * @return
	 */
	protected boolean shouldGenerateId() {
		return true;
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		super.doParse(element, parserContext, builder);
		System.out.println("wzycustomAttr标签属性转换对象属性wzyAttrJavaBeanValue");
		if (element.hasAttribute("wzycustomAttr")) {
			builder.addPropertyValue("wzyAttrJavaBeanValue", element.getAttribute("wzycustomAttr"));
		}

	}
}
