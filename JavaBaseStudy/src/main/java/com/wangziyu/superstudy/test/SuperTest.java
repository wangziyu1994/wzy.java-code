package com.wangziyu.superstudy.test;

import com.wangziyu.superstudy.model.Son;

public class SuperTest {
    /**
     * 子类构造器会默认调用父类无参构造器
     * super显示调用只能调用一次
     * super构造器和this构造器都要放在首行,所以不能共存
     * this()会调用自身构造方法  this.method 会调用子类重写的方法（多态)
     * @param args
     */
    public static void main(String[] args) {
        //Son son1=new  Son();
        Son son2=new  Son("wangziyu","17","basketBall");
        System.out.println(son2);
    }
}
