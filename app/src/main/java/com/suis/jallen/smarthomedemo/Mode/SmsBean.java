package com.suis.jallen.smarthomedemo.Mode;

public class SmsBean extends BaseBean{
    private int sendType;
    private String email;
    private String to;

    public int getSendType() {
        return sendType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
