package com.sinbin.net_.qq.common;

import java.io.Serializable;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 15:43
 * @Description:
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sender;
    private String receiver;
    private String content;
    private String sendTime;
    private String messageType;
    private byte[] filebytes;
    private int fileLen;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public byte[] getFilebytes() {
        return filebytes;
    }

    public void setFilebytes(byte[] filebytes) {
        this.filebytes = filebytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }
}
