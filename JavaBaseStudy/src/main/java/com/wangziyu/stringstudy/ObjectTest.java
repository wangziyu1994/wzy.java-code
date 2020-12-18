package com.wangziyu.stringstudy;

public class ObjectTest {
    public static void main(String args[]){
        Teacher teacher=new Teacher("wangziyu");
        Student student=new Student("wzystudent",teacher);
        System.out.println("带入方法前"+student.getTeacher());
        Student student1=setStudent(student);
        System.out.println("带入方法后"+student.getTeacher());
        System.out.println("带入方法后"+student1.getTeacher());
    }

    public static Student setStudent(Student student){
        student.setTeacher(new Teacher("wzystudent2"));
        return  student;
    }
}
