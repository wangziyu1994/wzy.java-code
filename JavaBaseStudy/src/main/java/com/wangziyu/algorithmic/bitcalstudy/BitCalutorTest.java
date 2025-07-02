package com.wangziyu.algorithmic.bitcalstudy;

import org.junit.jupiter.api.Test;

public class BitCalutorTest {

    @Test
    public void main1Test() {
        printBitNum(0);
        printBitNum(127);
        System.out.println(Integer.MAX_VALUE);
        printBitNum(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        printBitNum(Integer.MIN_VALUE);
    }

    @Test
    public void main2Test() {
        printBitNum(0);
        printBitNum(1);
        printBitNum(2);
        printBitNum(3);
        printBitNum(4);
    }

    @Test
    public void getBitTest() {
        System.out.println(getOneBitNum(0));
        System.out.println(getOneBitNum(1));
        System.out.println(getOneBitNum(2));
    }

    public void printBitNum(int num) {
        for (int i = 31; i >= 0; i--) {
           int bitValue=num&getOneBitNum(i);
           checkOneOrZero(bitValue);
        }
        System.out.println();
    }


    /**
     * 获取二进制 01  10 100 1000  100000
     * @param bitCount
     * @return
     */
    public int getOneBitNum(int bitCount) {
        int num;
        num = 1 << bitCount;
        return num;
    }

    public void checkOneOrZero(int temp) {
        System.out.print(temp==0?"0":"1");
    }


}
