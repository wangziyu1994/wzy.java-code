package com.wangziyu.innerstudy.test;

import com.wangziyu.innerstudy.model.ArrayAlg;

public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double [20];
         for (int i = 0; i < d.length; i++)
             d[i] = 100 * Math.random();
         ArrayAlg.Pair p = ArrayAlg.Pair.mininax(d);
         System.out.println("min = " + p.getFirst());
         System.out.println("max = " + p.getSecond());
    }
}
