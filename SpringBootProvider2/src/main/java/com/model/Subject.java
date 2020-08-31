package com.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@ApiModel(value="科目")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject  {

  //  @JacksonXmlProperty(localName = "scores1")
@ApiModelProperty(value = "分数")
@XmlElement(name="scores1")
private String scores;

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "scores='" + scores + '\'' +
                '}';
    }
}
