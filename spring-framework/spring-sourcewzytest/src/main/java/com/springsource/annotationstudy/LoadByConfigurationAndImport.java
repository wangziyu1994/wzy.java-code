package com.springsource.annotationstudy;

import com.springsource.custom.WzyAttrJavaBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WzyAttrJavaBean.class)
public class LoadByConfigurationAndImport {
}
