package com.wangziyu.genericstudy;

public class MyGenericMethod {

    /**
     * 普通类中静态泛型方法
     * @param b
     * @param <B>
     * @return
     */
    public  static <B>B get(B[] b){
        return b[0];
    }


}
