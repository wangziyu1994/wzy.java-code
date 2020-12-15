package com.mulpthread.Model;

import java.util.Arrays;

public class Bank {
    public  final double[] accounts;
    public Bank(int n,double initalBal ){
        accounts=new double[n];
        Arrays.fill(accounts,initalBal);
    }


    public double getTotalBal(){
        double sum=0;
        for(double var1:accounts){
            sum+=var1;
        }
        return sum;
    }

    public int getSize(){
        return accounts.length;
    }

    public void transFer(int from,int to,double amounts){
        if(accounts[from]<amounts) return;
        System.out.println("线程"+Thread.currentThread().getName());
        accounts[from]-=amounts;
        System.out.println("%10.2f from %d to %d",amount,from,to);
        accounts[to]+=amounts;
        System.out.println("TotalBal:%10.2f%n",getTotalBal());
    }
}
