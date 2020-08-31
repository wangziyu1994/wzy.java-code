package com.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ApiModel(value = "学生")
//@XmlAccessorType(value = XmlAccessType.FIELD)
//@XmlRootElement(name="Studentdfdf")
//@JacksonXmlRootElement(localName = "Student1")
public class Student  {

    @ApiModelProperty(value = "班级名字")
   // @JacksonXmlProperty(localName = "className1")
    //@XmlElement(name="className2")
    private String className;


    @ApiModelProperty(value = "公用头")
   // @JacksonXmlProperty(localName = "commentHead1")
   // @XmlElement(name="commonHead2")
private String commentHead;
    @ApiModelProperty(value = "科目")
    //@JacksonXmlProperty(localName = "subject1")
    //@XmlElement(name="subject2")

    private Subject subject;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public String getCommentHead() {
        return commentHead;
    }

    public void setCommentHead(String commentHead) {
        this.commentHead = commentHead;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", commentHead='" + commentHead + '\'' +
                ", subject=" + subject +
                '}';
    }
}
