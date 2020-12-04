package com.config;

import com.model.Student;
import com.model.Teacher;

public class ThreadLocalConfig {
    public static final ThreadLocal userThreadLocal = new ThreadLocal();
    public static final ThreadLocal studentThreadLocal = new ThreadLocal();

    public static void set(Teacher teacher) {
        userThreadLocal.set(teacher);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static Teacher get() {
        if((Teacher) userThreadLocal.get()==null){
            Teacher t=new Teacher();
            t.settName(Thread.currentThread().getName());
            set(t);
            System.out.println(Thread.currentThread().getName()+"创建teacher对象");
        }
        return (Teacher) userThreadLocal.get();
    }


    public static void sets(Student student) {
        studentThreadLocal.set(student);
    }


    public static Student gets() {
        if((Student) studentThreadLocal.get()==null){
            Student s=new Student();
            s.setClassName(Thread.currentThread().getName());
            sets(s);
           System.out.println(Thread.currentThread().getName()+"创建student对象");
        }
        return (Student) studentThreadLocal.get();
    }
}
