package com.wangziyu.mulpthread.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public final double[] accounts;
    public final List<Double> accountsList= Collections.synchronizedList(new ArrayList<>());
    public final ReentrantLock reentrantLock;
    public final Condition sufficientFunds;


    public Bank(int n, double initalBal) {
        accounts = new double[n];
        for(int a=0;a<n;a++){
            accounts[a]=Math.random()*100;
        }
        for(int a=0;a<n;a++){
            accountsList.add(100.0);
        }
        System.out.println(Arrays.toString(accounts));
      //  Arrays.fill(accounts, initalBal);
        reentrantLock = new ReentrantLock();
        sufficientFunds = reentrantLock.newCondition();
    }

    public double getTotalBal() {
        double sum = 0;
        for (double var1 : accounts) {
            sum += var1;
        }
        return sum;
    }

    public int getSize() {
        return accounts.length;
    }

    /**
     * 多线程，转账动作可能被打断不安全
     *
     * @param from
     * @param to
     * @param amounts
     */
    public void transFer(int from, int to, double amounts) {
        if (accounts[from] < amounts) return;
        accounts[from] -= amounts;
        System.out.printf("线程" + Thread.currentThread().getName() + " %10.2f from %d to %d", amounts, from, to);
        accounts[to] += amounts;
        System.out.printf("线程" + Thread.currentThread().getName() + " TotalBal: %10.2f%n", getTotalBal());
    }


    /**
     * 竞争条件下同步
     *
     * @param from
     * @param to
     * @param amounts
     */
    public void reentrantLockTransFer(int from, int to, double amounts) {
        reentrantLock.lock();
        try {
            if (accounts[from] < amounts) return;
            accounts[from] -= amounts;
            System.out.printf("线程" + Thread.currentThread().getName() + " %10.2f from %d to %d", amounts, from, to);
            accounts[to] += amounts;
            System.out.printf("线程" + Thread.currentThread().getName() + " TotalBal: %10.2f%n", getTotalBal());
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * 条件
     *
     * @param from
     * @param to
     * @param amounts
     */
    public void conditionalTransFer(int from, int to, double amounts) {
        reentrantLock.lock();
        try {
            while (accounts[from] < amounts) {
                System.out.println("线程" + Thread.currentThread().getName() + "  "+from+"资金不足进入await");
                sufficientFunds.await();
            }
            accounts[from] -= amounts;
            System.out.printf("线程" + Thread.currentThread().getName() + " %10.2f from %d to %d", amounts, from, to);
            accounts[to] += amounts;
            sufficientFunds.signalAll();
            System.out.println("线程" + Thread.currentThread().getName() + "转账到"+to+"成功");
            System.out.printf("线程" + Thread.currentThread().getName() + " TotalBal: %10.2f%n", getTotalBal());

        }
        catch (InterruptedException e){

        }
        finally {
            reentrantLock.unlock();
        }
    }


    public synchronized  void syschronizedTransFer(int from, int to, double amounts) {
        synchronized(accountsList) {
            if (accountsList.get(from) == 50) {
                System.out.println("线程同步被影响了");
            }
            accountsList.set(from, accountsList.get(from) + amounts);
            System.out.printf("线程" + Thread.currentThread().getName() + " %10.2f from %d to %d", amounts, from, to);
            accountsList.set(to, accountsList.get(to) - amounts);
            System.out.printf("线程" + Thread.currentThread().getName() + " TotalBal: %10.2f%n", getTotalBal());
            System.out.println("线程" + Thread.currentThread().getName() + "转账到" + to + "成功");

        }

    }
}
