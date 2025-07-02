package com.wangziyu.algorithmic;

import com.wangziyu.algorithmic.easysortstudy.BubbleSort;
import com.wangziyu.algorithmic.easysortstudy.InsertSort;
import com.wangziyu.algorithmic.easysortstudy.SelectSort;

import java.util.Arrays;

public class WzyMainTest {
    public static final int testTimes=100;
    public static void main(String[] args) {
           vailateArr();
    }

    public static void vailateArr(){
        for(int i=0;i<testTimes;i++){
            int arr[] = WzyUtils.generateRandomArray(10,100);
           // WzyUtils.printArr(arr);

            int[] copy1=WzyUtils.copyArr(arr);
            int[] copy2=WzyUtils.copyArr(arr);
            int[] copy3=WzyUtils.copyArr(arr);
            int[] copy4=WzyUtils.copyArr(arr);




            InsertSort.insertSort1(copy1);
            InsertSort.insertSort2(copy2);
            SelectSort.selectSort(copy3);
            BubbleSort.bubbleSort(copy4);


            //copy1[1]=1000;
            boolean insertRes1=WzyUtils.vailateArr(copy1);
            boolean insertRes2=WzyUtils.vailateArr(copy2);
            boolean selectRes=WzyUtils.vailateArr(copy3);
            boolean bubbleRes=WzyUtils.vailateArr(copy4);

            if(!insertRes1){
                System.out.println(Arrays.toString(copy1));
             System.out.println("insert1 error");
                return;
            }
            if(!insertRes2){
                System.out.println(Arrays.toString(copy2));
                System.out.println("insert2 error");
                return;
            }
            if(!selectRes){
                System.out.println(Arrays.toString(copy3));
                System.out.println("select error");
                return;
            }
            if(!bubbleRes){
                System.out.println(Arrays.toString(copy4));
                System.out.println("bubble error");
                return;
            }
        }

        System.out.println("sucess!");
    }
}
