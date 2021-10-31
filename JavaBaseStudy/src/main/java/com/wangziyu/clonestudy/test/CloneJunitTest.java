package com.wangziyu.clonestudy.test;

import com.wangziyu.clonestudy.model.School;
import com.wangziyu.clonestudy.model.Student;
import com.wangziyu.clonestudy.model.Teacher;
import org.junit.jupiter.api.Test;

public class CloneJunitTest {

    @Test
    public void test1() throws CloneNotSupportedException {

        Student student=new Student("saber",12);
        Teacher teacher=new Teacher(13,"saber");
        School school=new School(10,"sz-school",student,teacher);
        school.setStudent(student);

        School schoolCopy= (School) school.clone();
        System.out.println("school:"+String.valueOf(school==schoolCopy));
        System.out.println("teacher:"+String.valueOf(school.getTeacher()==schoolCopy.getTeacher()));
        System.out.println("student:"+String.valueOf(school.getStudent()==schoolCopy.getStudent()));

    }
}
