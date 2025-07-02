package com.wangziyu.algorithmic.dimidstudy;

import com.wangziyu.algorithmic.WzyUtils;

/**
 * 整体无序，相邻不等 求出第一个局部最小值(X-1>X<X+1)
 */
public class LocalMinTest {
    public static final int size=100000;
    public static void main(String[] args) {
       for(int i=0;i<size;i++){
           int[] arr= WzyUtils.randomArray(10,100);
           int minIndex=localMin(arr);
           if(!WzyUtils.checkLocalMin(arr,minIndex)){
               WzyUtils.printArr(arr);
               System.out.println();
               System.out.println("error");
               break;
           }
       }

        //System.out.println("finish");
    }


    public static int localMin(int[] arr){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }


        int L=0;
        int R=N-1;
        // L...R 肯定有局部最小
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }

        return arr[L] < arr[R] ? L : R;
    }





}
