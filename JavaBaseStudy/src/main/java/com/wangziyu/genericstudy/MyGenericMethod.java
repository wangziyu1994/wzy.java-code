package com.wangziyu.genericstudy;

import java.util.LinkedList;
import java.util.List;

public class MyGenericMethod <E> extends Parents{

    public List<E> eList=new LinkedList<>();

    /**
     * 这不是泛型方法，是泛型类的使用
     * @param e
     * @return
     */
    public E getEMethod(E e){
        return  e;
    }
    /**
     * 普通类中静态泛型方法
     * @param b
     * @param <B>
     * @return
     */
    public  static <B>B get(B[] b){
        return b[0];
    }


    /**
     * 普通类中实例泛型方法
     * @param a
     * @param <A>
     * @return
     */
    public <A> A  getAMethod(A a){
        return a;
    }


    /**
     * 泛型通配符
     * @param myGenericMethod
     * @return
     */
    public MyGenericMethod<?>  unSureClassMethod(MyGenericMethod<?> myGenericMethod){
        List<?> list=myGenericMethod.eList;
        return myGenericMethod;
    }


    /**
     * 泛型通配符上限
     * @param myGenericMethod
     * @return
     */
    public static MyGenericMethod<? extends Parents>  unSureClassMethodExtend(MyGenericMethod<? extends Parents> myGenericMethod){
        List<? extends Parents> list=myGenericMethod.eList;
        return myGenericMethod;
    }

    /**
     * 泛型通配符下限
     * @param myGenericMethod
     * @return
     */
    public static MyGenericMethod<? super Son>  unSureClassMethodSuper(MyGenericMethod<? super Son> myGenericMethod){
        List<? super Son> list=myGenericMethod.eList;
        return myGenericMethod;
    }

    public void test(){
        unSureClassMethod(new MyGenericMethod<SonOfSon>());
        unSureClassMethodExtend(new MyGenericMethod<SonOfSon>());
        unSureClassMethodSuper(new MyGenericMethod<ParOfParent>());
    }
}
