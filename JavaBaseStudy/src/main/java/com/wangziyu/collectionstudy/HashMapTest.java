package com.wangziyu.collectionstudy;

import com.wangziyu.collectionstudy.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
            Map<String, Employee> staff = new HashMap() ;
            staff. put("144-25-5464", new Employee("Amy Lee"));
            staff. put("567-24-2546", new Employee("Harry Hacker"));
            staff. put("157-62-7935", new Employee("Cary Cooper"));
            staff.put("456-62-5527", new Employee("Francesca Cruz"));
// print all entries
            System.out.println(staff);
// remove an entry
            staff. remove ("567-24-2546");
// replace an entry
            staff.put("456-62-5527", new Employee("Francesca Hiller"));
// look up a value
            System.out.println(staff.get("157-62-7935"));

            staff.forEach((k,v) ->
            System.out.println("key:"+k+"value:"+v));
    }
}
