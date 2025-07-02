package com.wangziyu.rpcstudy.model;

public class PacketMsg {
    private MessageBody messageBody;
    private MessageHeader messageHeader;

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    @Override
    public String toString() {
        return "PacketMsg{" +
                "messageBody=" + messageBody +
                ", messageHeader=" + messageHeader +
                '}';
    }
}
