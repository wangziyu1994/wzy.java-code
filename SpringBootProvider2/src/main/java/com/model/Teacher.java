package com.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Teacher {
    @JSONField(name="tName1")
    @JsonProperty(value="tName1")
    private String tName;
    @JSONField(name="tId1")
    @JsonProperty(value="tId1")
    private String tId;

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tName='" + tName + '\'' +
                ", tId='" + tId + '\'' +
                '}';
    }
}
