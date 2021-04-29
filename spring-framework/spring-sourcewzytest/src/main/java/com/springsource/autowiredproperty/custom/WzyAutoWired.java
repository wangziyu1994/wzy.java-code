package com.springsource.autowiredproperty.custom;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WzyAutoWired {

}
