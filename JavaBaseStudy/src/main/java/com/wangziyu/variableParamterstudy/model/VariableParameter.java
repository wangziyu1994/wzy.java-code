package com.wangziyu.variableParamterstudy.model;

public class VariableParameter {

    public static void method1(Object... args){
        for(int i=0;i<=args.length-1;i++){
            System.out.println(args[i]);
        }
    }
}
