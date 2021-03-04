package com.wangziyu.caldatamodelstudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SimpleSortMethod {

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
        /*for(int i=1;i<=length-2;i++){
        //重复上面的循环,最终
        do()
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


    /**
     * 冒泡排序：[0]------->[n-1] 两两比较 遇到较小的值则交换位置
     * O(n2)
     * 时间复杂度  n-1 + n-2 .....+2+1
     * 空间复杂度  n + n-1
     */
    @Test
    public void test3(){
        int length=arr.length;
        //第一次遍历[0]----------> [n-2]  两两比较 遇到较小的值则交换位置
        for(int i=0;i<=length-2;i++){
            if(arr[i]>arr[i+1]){
               int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }

        System.out.println(Arrays.toString(arr));

        //重复这种遍历直到 ([0]---->[n-2])--------->([0]------>[1])
        /*for(int i=1;i<=length-2;i++){
        //重复上面的循环,最终
        }*/

    }




    @Test
    public void test4(){
        int length=arr.length;
        for(int i=length-2;i>=1;i--) {
            //第一次遍历[0]----------> [n-2]  两两比较 遇到较小的值则交换位置
            for (int j = 0; j <=i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }



    /**
     * 插入排序：[0]------->[1] 两两比较 遇到较小的值则将较小的值放在首位
     * O(n2)
     * 时间复杂度  n-1 + n-2 .....+2+1
     * 空间复杂度  n + n-1
     */
    @Test
    public void test5(){
        int length=arr.length;
        //第一次遍历[0]----------> [1]  将较小的值移到前一位
        for(int i=0;i<1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }

        System.out.println(Arrays.toString(arr));

        //重复这种遍历直到 ([0]---->[1])--------->([0]------>[n-1])
        /*for(int i=1;i<=length-1;i++){
        //重复上面的循环,最终
        do()
        }*/

    }


    @Test
    public void test6(){
        int length=arr.length;
        //第一次遍历[0]----------> [n-2]   将较小的值移到前一位
        for(int i=0;i<length-1;i++) {
            for (int j = 0; j <i+1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));



    }




























@Test
    public void updateStr1(){
        String str="sdfsdf";
        Integer inr=1000000;
    updateStr(str);
    updateInteger(inr);
    System.out.println(str);
    System.out.println(inr);
    }

    public void updateStr(String str){
        str="aaaa";
    }

    public void updateInteger(Integer integer){
        integer=11111111;
    }
}
