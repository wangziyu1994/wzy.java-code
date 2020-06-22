package com.controller;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyValidator.class)
public @interface ValidatorAnno1 {
    String message() default "dsfdsf";
    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};

}
