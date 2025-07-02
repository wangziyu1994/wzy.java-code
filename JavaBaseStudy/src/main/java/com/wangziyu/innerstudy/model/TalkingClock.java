package com.wangziyu.innerstudy.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start()

    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

    }

    public void startLocalClass()
    {
         class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    System.out.println("At the tone, the time is " + new Date());
                    if (beep) Toolkit.getDefaultToolkit().beep();
                }
            }

        }
    }
}
