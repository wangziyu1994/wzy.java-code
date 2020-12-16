package com.mulpthread.test;

import com.mulpthread.model.Bank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest1 {
    @Test
    public void test() {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            list.add(50.0);
        }
        for (int i = 0; i < 10; i++) {
            list.set(i, 50.0);
        }
        List<Bank> bankList = new ArrayList<Bank>();
        for (int i = 0; i < 10; i++) {
           // bankList.add(new Bank());
        }
        for (int i = 0; i < 10; i++) {
            //   bankList.get(i).accountsList.set();
        }
    }

}
