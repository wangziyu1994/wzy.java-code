package com.wangziyu.algorithmic.easysortstudy;

import com.wangziyu.algorithmic.WzyUtils;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = WzyUtils.generateRandomArray(10,100);
        bubbleSort(arr);
        WzyUtils.vailateArr(arr);
    }

    //0-n-1  选出min 交换arr[0]-arr[1]  arr[1]-arr[2]  arr[2]-arr[3] ...
    //0-n-2  选出min  交换arr[0]-arr[1]  arr[1]-arr[2]  arr[2]-arr[3] ...
    //0-1    选出min  交换arr[0]-arr[1]
    //
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int N = arr.length;
        //0-n-1 0-n-2 .... 0-1  控制多层遍历
        for (int i = N-1; i >0; i--) {
            //遍历选出最小值的下标
            for (int j =0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swapValue(arr,j,j+1);
                }
            }
        }

    }


    public static void swapValue(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void rightSort(int[] arr) {
        int[] copy=arr.clone();
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
    }
}
