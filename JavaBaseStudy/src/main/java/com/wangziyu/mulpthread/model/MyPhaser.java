package com.wangziyu.mulpthread.model;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {

        switch (phase) {
            case 0:
                System.out.println("所有人到齐了！" + registeredParties);
                System.out.println();
                return false;
            case 1:
                System.out.println("所有人吃完了！" + registeredParties);
                System.out.println();
                return false;
            case 2:
                System.out.println("所有人离开了！" + registeredParties);
                System.out.println();
                return false;
            case 3:
                System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties);
                return true;
            default:
                return true;
        }
    }

}
