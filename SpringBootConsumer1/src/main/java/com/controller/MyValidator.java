package com.controller;






import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class MyValidator implements ConstraintValidator<ValidatorAnno1,Object> {
    @Override
    public void initialize(ValidatorAnno1 constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        try {
            String a= BeanUtils.getProperty(value,"a");
            String b= BeanUtils.getProperty(value,"b");
            String c= BeanUtils.getProperty(value,"c");
            if(a!=null&&!a.equals("")){

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



        return false;
    }
}
