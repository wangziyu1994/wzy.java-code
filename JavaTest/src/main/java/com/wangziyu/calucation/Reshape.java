package com.wangziyu.calucation;

import java.util.Arrays;

public class Reshape {
    public static void main(String[] args) {
        int[][] test={{1,2},{3,4},{5,6}};
        int[][] result=matrixReshape(test,6,1);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.println(result[i][j]);
            }
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length<=0){
            return nums;
        }
        if(nums[0].length<=0){
            return nums;
        }
        int c0=nums[0].length;
        int r0=nums.length;
        if(r0*c0!=r*c){
            return nums;
        }
        int[][] newnums=new int[r][c] ;
        int tempc=c0;
        int tempr=r0;
        for(int i=0;i<r0;i++){
            int tempi=i+1;
            for(int j=0;j<c0;j++){
                int tempj=j+1;
                if(tempi>r){
                    newnums[r-1][tempc]=nums[i][j];
                    System.out.println( r-1+":"+tempc);
                    tempc++;
                    continue;
                }
                if(tempj>c){
                    newnums[tempr][c-1]=nums[i][j];
                    System.out.println( tempr+":"+(c-1));
                    tempr++;
                    continue;
                }
                newnums[i][j]=nums[i][j];
                System.out.println(newnums[i][j]);
            }
        }
        return newnums;
    }


}
