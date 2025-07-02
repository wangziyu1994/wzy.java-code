package com.wangziyu.algorithmic.easysortstudy;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = generateRandomArray(10,100);
        rightSort(arr);
        printArr(arr);
        insertSort1(arr);
        printArr(arr);
        insertSort2(arr);
        printArr(arr);
    }

    //0,1 比较 选出min 交换arr[0]  arr[1];
    //2  和  0,1 比较 选出min 交换arr[2]  0-1
    //...
    //n-1 和 0- n-1 比较   选出min 交换arr[n-1]  0-n-2
    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int N = arr.length;
        //0-1  0-2  0-3 ....  0-n-1 控制多层遍历
        for (int i = 1; i <= N - 1; i++) {
            //遍历选出最小值的下标
            int currentIndex=i;
          while(currentIndex>0&&arr[currentIndex]<arr[currentIndex-1]) {
                  //排序好当前数组
                  swapValue(arr, currentIndex, currentIndex - 1);
              currentIndex--;
          }

        }

    }
    //排序好0,1
    //排序好0,1,2
    //排序好0,1,2,3 。。。
    //排序好0-n-1
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int N = arr.length;
        //0-1  0-2  0-3 ....  0-n-2 控制多层遍历
        for (int i = 1; i <= N - 1; i++) {
            for (int currentIndex = i;currentIndex>0&&arr[currentIndex]<arr[currentIndex-1];currentIndex--) {
                    swapValue(arr, currentIndex, currentIndex-1);

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


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() * N -> [0,N) 所有小数，等概率返回一个
        // (int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            arr[i]=Math.abs(arr[i]);
        }
        return arr;
    }
}
