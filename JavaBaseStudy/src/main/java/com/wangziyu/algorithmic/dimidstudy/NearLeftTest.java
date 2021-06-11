package com.wangziyu.algorithmic.dimidstudy;

import com.wangziyu.algorithmic.WzyUtils;
import com.wangziyu.algorithmic.easysortstudy.SelectSort;

public class NearLeftTest {
    public static void main(String[] args) {
        int[] arr = WzyUtils.generateRandomArray(10, 100);
        SelectSort.selectSort(arr);
        WzyUtils.printArr(arr);
        int param = (int) (Math.random() * 100);

        int varnearLeft = WzyUtils.vailateNearLeft(arr, param);
        System.out.println("varrLeftResult:" + varnearLeft);
        int nearLeft = firstLowerNum(arr, param);
        System.out.println("firstNearLeft:" + nearLeft);
        int rightLeft = firstLowerRightNum(arr, param);
        System.out.println("rightLeft:" + rightLeft);
    }





    /**
     * 给定一个有序数组，给定任意一个数。返回数组中>=此数的第一个数。没有返回-1
     * @return
     */
    public static int  firstLowerNum(int[] arr,int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return arr[0] >= num ? 0 : -1;
        }

        int mid = 0;
        int L = 0;
        int R = arr.length-1;
        int temp=-1;

        while (L <= R) {
            mid = (L + R) / 2;
            if (arr[mid] >= num) {
                temp=mid;
                R = mid - 1;
            } else if (arr[mid] < num) {
                L = mid + 1;
            }
        }
        return temp;
    }


    /**
     * 给定一个有序数组，给定任意一个数。返回数组中>=此数的第一个数。没有返回-1
     * @return
     */
    public static int  firstLowerRightNum(int[] arr,int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return arr[0] >= num ? 0 : -1;
        }

        int mid = 0;
        int L = 0;
        int R = arr.length-1;
        int temp=-1;

        while (L <= R) {
            mid = (L + R) / 2;
            if (arr[mid] >= num) {
                temp=mid;
                R = mid - 1;
            } else if (arr[mid] < num) {
                L = mid + 1;
            }
        }
        return temp;
    }
}
