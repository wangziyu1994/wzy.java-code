package com.wangziyu.clonestudy.test;

import com.wangziyu.clonestudy.model.Employee;

public class CloneTest {
    public static void main(String[] args){
        try {
            Employee original =new Employee("wangziyu", 5000);
            original.setHireDay(2020, 1, 1);
            Employee copy = original.clone();
            copy.setName("wangziyutest");
            copy.raiseSalary(20);
            copy.setHireDay(2021, 1, 1);
            System.out.println("orignal= " + original);
            System.out.println("copy= " + copy);
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
