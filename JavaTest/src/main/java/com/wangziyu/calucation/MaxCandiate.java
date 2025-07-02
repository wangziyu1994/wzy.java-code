package com.wangziyu.calucation;

import java.util.ArrayList;
import java.util.List;

public class MaxCandiate {
    public static void main(String[] args) {
        int[] var={2,3,5,1,3};
        List<Boolean> arr=kidsWithCandies(var,3);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int length=candies.length;
        int[] arr2=new int[length];
        List<Boolean> result=new ArrayList(length);
        for(int i=0;i<length;i++){
            arr2[i]=candies[i]+extraCandies;
        }
        int max=0;
        for(int i=0;i<length;i++){
            if(max<=candies[i]){
                max=candies[i];
            }
        }
        System.out.println(max);

        for(int i=0;i<length;i++){
            if(arr2[i]>=max){
                result.add(true);
            } else{
                result.add(false);
            }
        }
        return result;
    }
}
