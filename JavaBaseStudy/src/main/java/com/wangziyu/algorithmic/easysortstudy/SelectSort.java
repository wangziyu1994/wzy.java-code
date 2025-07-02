package com.wangziyu.algorithmic.easysortstudy;

import com.wangziyu.algorithmic.WzyUtils;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = WzyUtils.generateRandomArray(10,100);
        rightSort(arr);
        printArr(arr);
        selectSort(arr);
        printArr(arr);
    }

    //0-n-1  选出min 交换arr[0]  arr[min]
    //1-n-1  选出min 交换arr[1]  arr[min]
    //...
    //n-2 n-1   选出min 交换arr[n-2] arr[min]
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int N = arr.length;
        //0-n-1 1-n-1 .... n-2-n-1  控制多层遍历
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            //遍历选出最小值的下标
            for (int j = i + 1; j <= N - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //选出min 的index,并且交换值
            swapValue(arr, minIndex, i);
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
