package com.wangziyu.resourcestudy;

import org.junit.jupiter.api.Test;

public class ResoureTest {
    public static final String fileName="target.properties";


    @Test
    public void testClassResource(){
        Package currClassPath=this.getClass().getPackage();
        String packageName=currClassPath.getName();
        packageName=packageName.replace(".","/")+"/";
        System.out.println(packageName);
        System.out.println(this.getClass().getResource(fileName));
        System.out.println(this.getClass().getResource("/"+packageName+fileName));
        System.out.println(this.getClass().getClassLoader().getResource(packageName+fileName));
        System.out.println(this.getClass().getClassLoader().getResource("/"+packageName+fileName));
    }
}
