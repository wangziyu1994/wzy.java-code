package com.wangziyu.algorithmic;

import java.util.Arrays;

public class WzyUtils {
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
        printArr(copy);
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

    public static int[] generateSureArray(int maxSize, int maxValue) {
        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() * N -> [0,N) 所有小数，等概率返回一个
        // (int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
        int[] arr = new int[(int) (maxSize)]; // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            arr[i]=Math.abs(arr[i]);
        }
        return arr;
    }


    public static int[] generateSizeRandomArray(int size, int maxValue) {
        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() * N -> [0,N) 所有小数，等概率返回一个
        // (int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
        int[] arr = new int[size]; // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            arr[i]=Math.abs(arr[i]);
        }
        return arr;
    }

    //排序对数器
    public static boolean vailateArr(int[] arr){
        if(arr.length<=2){
            return true;
        }
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
         if(arr[i]<min){
             System.out.println("第"+i+"位排序出错"+arr[i]);
            return false;
         }
         min=Math.max(min,arr[i]);
        }
        return true;
    }

    //复制数组
    public static int[] copyArr(int[] arr){
        int[] copy=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copy[i]=arr[i];
        }
        return  copy;
    }


    //查询数组是否包含元素
    public static int vailateArrElement(int[] arr,int param){
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return arr[0] == param ? 0 : -1;
        }

        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]==param){
                return i;
            }
        }

        return -1;
    }




    public static int vailateNearLeft(int[] arr,int param){
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return arr[0] <= param ? 0 : -1;
        }

        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]>=param){
                return i;
            }
        }
        return -1;
    }



    public static int  vailateLocalMin(int[] arr,int minIndex){
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left=minIndex-1;
        int right=minIndex+1;



        boolean real=false;
        boolean leftFlag=arr[minIndex-1]>arr[minIndex];
        boolean rightFlag=arr[minIndex+1]>arr[minIndex];
        real=leftFlag&&rightFlag;
        if(real){
            return minIndex;
        }else{
            return -1;
        }


    }


    // 也用于测试
    public static boolean checkLocalMin(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }


    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }



    // arr 整体无序
    // arr 相邻的数不相等！
    public static int oneMinIndex(int[] arr) {
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
        int L = 0;
        int R = N - 1;
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
