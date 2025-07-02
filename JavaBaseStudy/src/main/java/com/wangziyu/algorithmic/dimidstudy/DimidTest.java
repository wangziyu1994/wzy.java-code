package com.wangziyu.algorithmic.dimidstudy;

import com.wangziyu.algorithmic.WzyUtils;
import com.wangziyu.algorithmic.easysortstudy.SelectSort;
import org.junit.jupiter.api.Test;

public class DimidTest {
    public static void main(String[] args) {
        int[] arr = WzyUtils.generateRandomArray(10, 100);
        SelectSort.selectSort(arr);
        WzyUtils.printArr(arr);
        int param = (int) (Math.random() * 100);


        System.out.println("param:" + param);
        int valresult = WzyUtils.vailateArrElement(arr, param);
        System.out.println("valresult:" + valresult);
        int midresult = midQryNum(arr, param);
        System.out.println("midresult:" + midresult);


    }

    /**
     * 给定一个有序数组，给定任意一个数。返回数组中此数的位置。没有返回-1
     */
    public static int midQryNum(int[] arr, int param) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return arr[0] == param ? 0 : -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L<=R) {
            mid = (L + R) / 2;

            if (arr[mid] == param) {
                return mid;
            }

            if (arr[mid] < param) {
                L = mid + 1;
            }
            else{
                R = mid - 1;
            }
        }
        return -1;
    }



}
