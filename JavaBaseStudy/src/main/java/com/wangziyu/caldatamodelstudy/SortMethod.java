package com.wangziyu.caldatamodelstudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortMethod {

    public static int[] arr={5,7,1,3,2,6,9,4};
    /**
     * 选择排序：每次遍历数组，找出最小值的位置，把最小值移到数组的首位。直到最后一次循环到n-1的位置
     * O(n2)
     * 时间复杂度  n-1 + n-2 .....+2+1
     * 空间复杂度  n + n-1
     */
    @Test
    public void test1(){
        //定义一个最小值的位置
        int minPox=0;
        int length=arr.length;
        int temp=arr[1];
       //第一次遍历[1]----------> [n-1]  先标记处最小值的位置,最后再进行值交换
        for(int i=1;i<=length-1;i++){
            if(arr[minPox]>arr[i]){
                temp=arr[minPox];
                minPox=i;
            }
        }
        arr[0]=arr[minPox];
        arr[minPox]=temp;
        System.out.println(arr[0]+" "+arr[minPox]);

        //重复这种遍历直到 ([1]---->[n-1])--------->([n-2]------>[n-1])
        /*for(int i=1;i<=length-2){
        //重复上面的循环,最终
        }*/

    }

    @Test
    public void test2(){
        //定义一个最小值的位置
        int minPox=0;
        int length=arr.length;
        //最终形态
        for(int i=0;i<=length-2;i++){
            int temp=arr[i];
            for(int j=i+1;j<=length-1;j++){
                if(arr[minPox]>arr[j]){
                    minPox=j;
                }
            }
            arr[i]=arr[minPox];
            arr[minPox]=temp;
        }
        System.out.println("选择排序后:"+ Arrays.toString(arr));
    }
}
