package com.wangziyu.innerstudy.test;

import com.wangziyu.innerstudy.model.TalkingClock;

import javax.swing.*;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock=new TalkingClock(1000,true);
        clock.start();
        // keep program running until user selects "0k"
         JOptionPane.showMessageDialog(null, "Quit program?");
         System.exit(0);
    }
}
