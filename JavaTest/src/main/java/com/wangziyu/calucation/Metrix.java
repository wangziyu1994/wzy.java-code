package com.wangziyu.calucation;

public class Metrix {
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(arr));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean flag=true;
        for(int i=0;i<m-1;i++){
            for(int j=i+1;j<=m;j++) {
                if (matrix[i][0] != matrix[i + 1][j]) {
                    flag = false;
                    break;
                }
            }

        }

        for(int i=0;i<n-1;i++){
            if(matrix[1][i]!=matrix[i+1][i+1]){
                flag=false;
                break;
            }

        }
        return flag;
    }
}
