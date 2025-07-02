package com.wangziyu.rpcstudy.model;

import java.io.Serializable;

public class MessageHeader implements Serializable {
    int flag;
    long requestID;
    long datalen;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public long getDatalen() {
        return datalen;
    }

    public void setDatalen(long datalen) {
        this.datalen = datalen;
    }

    @Override
    public String toString() {
        return "MessageHeader{" +
                "flag=" + flag +
                ", requestID=" + requestID +
                ", datalen=" + datalen +
                '}';
    }
}
