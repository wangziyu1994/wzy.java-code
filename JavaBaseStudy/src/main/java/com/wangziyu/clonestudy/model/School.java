package com.wangziyu.clonestudy.model;

public class School implements Cloneable{
    private int id;
    private String name;
    private Student student;
    private Teacher teacher;

    public School() {
    }

    public School(int id, String name, Student student, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.student = student;
        this.teacher=teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        School school=(School) super.clone();
        Teacher teacher= (Teacher) school.teacher.clone();
        System.out.println("student is null"+school.teacher==null);
        System.out.println("student is null"+school.student==null);
        System.out.println("student is null"+student==null);
        school.setTeacher(teacher);
        return school;
    }
}
