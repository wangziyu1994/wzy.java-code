package com.wangziyu.SingleBeanTest;

/**
 * 懒汉式单例模式
 */
public class SingleBeanInital1 {

    private static SingleBeanInital1 singleBeanInital1 = null;

    //私有化构造器
    private SingleBeanInital1() {

    }


    public static SingleBeanInital1 getSingleBeanInital11() {
        //但多线程同是进入此方法则会出现线程安全问题
        //多个线程同是会认为为null从而出现两个Bean
        singleBeanInital1 = new SingleBeanInital1();

        return singleBeanInital1;


    }

    //添加syschronized 代码块或者syschronized同步方法可以解决线程安全问题，但是每次都要事先获取锁对象，所以会导致效率低下问题
    //synchronized同步方法
    public static synchronized SingleBeanInital1 getSingleBeanInital12() {


        if (singleBeanInital1 == null) {

            singleBeanInital1 = new SingleBeanInital1();
        }

        return singleBeanInital1;


    }

    //synchronized同步代码块
    public static SingleBeanInital1 getSingleBeanInital23() {

        synchronized (SingleBeanInital1.class) {
            if (singleBeanInital1 == null) {

                singleBeanInital1 = new SingleBeanInital1();
            }
        }
        return singleBeanInital1;


    }

    //最终优化方法只有第一次 获取锁对象，其他时间不过去锁对象
    public static SingleBeanInital1 getSingleBeanInital33() {

        if (singleBeanInital1 == null) {
            synchronized (SingleBeanInital1.class) {
                if (singleBeanInital1 == null) {
                    singleBeanInital1 = new SingleBeanInital1();
                }
            }
        }
        return singleBeanInital1;

    }
}



