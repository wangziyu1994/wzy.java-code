package com.wangziyu.thinkmodel.observer;

import java.util.Date;

public class CryEvent {
    private Date cryTime;
    private String cryName;

    public CryEvent(Date cryTime, String cryName) {
        this.cryTime = cryTime;
        this.cryName = cryName;
    }

    public Date getCryTime() {
        return cryTime;
    }

    public void setCryTime(Date cryTime) {
        this.cryTime = cryTime;
    }

    public String getCryName() {
        return cryName;
    }

    public void setCryName(String cryName) {
        this.cryName = cryName;
    }
}
