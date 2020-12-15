package com.mulpthread.model;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public  final double[] accounts;
    public  final ReentrantLock reentrantLock=new ReentrantLock();
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
        accounts[from]-=amounts;
        System.out.printf("线程"+Thread.currentThread().getName()+" %10.2f from %d to %d",amounts,from,to);
        accounts[to]+=amounts;
        System.out.printf("线程"+Thread.currentThread().getName()+" TotalBal: %10.2f%n",getTotalBal());
    }


    public void reentrantLockTransFer(int from,int to,double amounts){
        reentrantLock.lock();
        try {
            if (accounts[from] < amounts) return;
            accounts[from] -= amounts;
            System.out.printf("线程" + Thread.currentThread().getName() + " %10.2f from %d to %d", amounts, from, to);
            accounts[to] += amounts;
            System.out.printf("线程" + Thread.currentThread().getName() + " TotalBal: %10.2f%n", getTotalBal());
        }
        finally {
            reentrantLock.unlock();
        }
    }
}
