package com.xujian.mail;

public class Mail {
    /**
     * 发送者
     */
    private String sender;

    /**
     * 接受者
     */
    private String receiver;

    /**
     * 主题
     */
    private String subject;

    /**
     * 发送 消息
     */
    private String text;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Mail [sender=" + sender + ", receiver=" + receiver + ", subject=" + subject + ", text=" + text + "]";
    }
}
