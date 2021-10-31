package com.wangziyu.jdk8new.lambdastudy.test;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import javax.swing.Timer;

/**
 * 1、（参数列表）：括号中的参数列表的数据类型，可以省略不写
 * 2、（参数列表）：括号中的参数只有一个，那么类型和（）都可以省略
 * 3、（参数列表）：如果{ }中的代码只有一行，无论是否有返回值，都可以省略（{ }， return , 分号 ）
 * 注意：要省略{ }， return , 分号，必须一起省略
 */
public class LambdaTest {
    public static void main(String[] args) {
        /**
         * 传入普通lamdba表达式
         */
        Comparator<String> comparator1 = (String first, String second) ->
        {
            if (first.length() < second.length()) return -1;
            else if (first.length() > second.length()) return 1;
            else return 0;

        };

        /**
         * 如果入参类型可以由上下推导得出，则可以省略参数类型.
         */
        Comparator<String> comparator2
                = (first, second) // Same as (String first, String second)
                -> first.length() - second.length();



/**
 * 如果入参类型可以由上下推导得出，且只有一个入参，则可以省略小括号.
 */
        ActionListener actionListener = event
                -> System.out.println("The Time is " + new Date());


        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");

        Arrays.sort(planets,(first,second)->first.length()-second.length());
        Timer t = new Timer(1000, actionListener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}
