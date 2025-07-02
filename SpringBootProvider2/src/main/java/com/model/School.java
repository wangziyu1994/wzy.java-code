package com.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class School {

    @JSONField(name="SchoolName1")
   // @JsonProperty(value="SchoolName1")
    private String schoolName;
    @JSONField(name="Teacher1")
   // @JsonProperty(value="Teacher1")
    private Teacher teacher;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
