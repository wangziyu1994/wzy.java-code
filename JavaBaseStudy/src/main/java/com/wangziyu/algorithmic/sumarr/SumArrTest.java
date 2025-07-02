package com.wangziyu.algorithmic.sumarr;

import com.wangziyu.algorithmic.WzyUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 设计一种算法,快速统计数组 arr[i]  arr[j]之间元素的累加值
 */
public class SumArrTest {
    public final int[] arr = WzyUtils.generateSizeRandomArray(10, 10);

    /**
     * 设计二维数组
     */
    @Test
    public void arrTable() {
        System.out.println(Arrays.toString(arr));
        System.out.println(rigthSum(arr, (int)Math.random()*100, (int)Math.random()*100));
        int[] rowarr = arr.clone();
        int[] columnarr = arr.clone();

        int[][] table = new int[rowarr.length][rowarr.length];


    }


    /**
     * 前缀辅助数组
     */
    @Test
    public void testhelpArr() {
        System.out.println(Arrays.toString(arr));
        int[] temp=compare(9);
        System.out.println(temp[0]+" "+temp[1]);
        System.out.println(rigthSum(arr, temp[0], temp[1]));
        System.out.println(preArrSum(arr,temp[0], temp[1]));


    }

    public int preArrSum(int[] arr, int startIndex, int endIndex){
        int[] helparr=new int[arr.length];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            helparr[i]=sum;
        }
        System.out.println(Arrays.toString(helparr));
        if(startIndex==0){
            return  helparr[endIndex];
        }
        return  helparr[endIndex]-helparr[startIndex-1];
    }

    public int rigthSum(int[] arr, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];
        }
        return sum;
    }


    public int[] compare(int maxSize){
        int temp1=(int)((maxSize + 1) * Math.random());
        int temp2=(int)((maxSize + 1) * Math.random());
        int[] arr=new int[2];
        if(temp1<=temp2){
            arr[0]=temp1;
            arr[1]=temp2;
        }else {
            arr[0]=temp2;
            arr[1]=temp1;
        }
        return arr;
    }
}
