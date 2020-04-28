package com.wangziyu.service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JavaToXml {

    public String  convertToXml (Object o,Class<?> classz) throws Exception{
        JAXBContext context=JAXBContext.newInstance(classz);
        Marshaller  marshaller=context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,"");
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");
        StringWriter sf=new StringWriter();
        marshaller.marshal(o,sf);
        return sf.toString();
    }
}
