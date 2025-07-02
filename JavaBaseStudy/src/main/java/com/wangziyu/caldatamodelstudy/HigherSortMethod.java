package com.wangziyu.caldatamodelstudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HigherSortMethod {

    public static int[] arr={38,55,65,97,27,76,28,18,19,99,23,11,20,13,14,27,3,8,1,66,78};

    /**
     * 希尔排序
     * 1,指定间隔
     * 2,按间隔遍历数组 将元素和元素下标加上间隔值的元素做插入排序.
     * 3,将间隔不断缩小最小到1（即为普通插入排序）完成
     *
     */
    @Test
    /**
     *   1,指定间隔
     *   2,按间隔遍历数组 将元素和元素下标加上间隔值的元素做插入排序.
     */
    public void test1(){
        //指定间隔
        int gap=5;
        int length=arr.length;
        // [38],55,65,97,27,[76],27,13,19,27,[13],19,27,13,19,[27],13,19,27,13,[19]
        //遍历数组,将元素和元素下标加上间隔值的元素做插入排序.
        for(int i=0;i<=length-gap-1;i=i+gap){
            if(arr[i]>arr[i+gap]){
                int temp=arr[i];
                arr[i]=arr[i+gap];
                arr[i+gap]=temp;
            }
        }
        //预期值 [38], 55, 65, 97, 27, [13], 27, 13, 19, 27,[27], 19, 27, 13, 19, [19], 13, 19, 27, 13, [76]
        //预期值 38, [55], 65, 97, 27, 13, [27], 13, 19, 27,27,[19], 27, 13, 19, 19, [13], 19, 27, 13, 76
        System.out.println(Arrays.toString(arr));

        for(int i=1;i<=length-gap-1;i=i+gap){
            if(arr[i]>arr[i+gap]){
                int temp=arr[i];
                arr[i]=arr[i+gap];
                arr[i+gap]=temp;
            }
        }
        //预期值 38, [27], 65, 97, 27, 13, [19], 13, 19, 27,27,[13], 27, 13, 19, 19, [55], 19, 27, 13, 76
        System.out.println(Arrays.toString(arr));
        //............重复上面的循环 0-------------->length-gap-1

        for(int i=1;i<=length-gap-1;i=i+gap){
            if(arr[i]>arr[i+gap]){
                int temp=arr[i];
                arr[i]=arr[i+gap];
                arr[i+gap]=temp;
            }
        }
    }



    @Test
    /**
     *  按间隔遍历数组 将元素和元素下标加上间隔值的元素做插入排序.
     */
    public void test2(){
        int length=arr.length;
        int gap=5;
        for(int j=0;j<=length-gap-1;j++) {
            for (int i = j  ; i <= length - gap - 1; i = i + gap) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    @Test
    /**
     *  将间距缩小,直至间距为1
     */
    public void test3(){
        int length=arr.length;
        for(int gap=5;gap>=1;gap--) {
            for (int j = 0; j <= length - gap - 1; j++) {
                for (int i = j; i <= length - gap - 1; i = i + gap) {
                    if (arr[i] > arr[i + gap]) {
                        int temp = arr[i];
                        arr[i] = arr[i + gap];
                        arr[i + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
