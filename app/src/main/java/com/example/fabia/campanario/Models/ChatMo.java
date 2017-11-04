package com.example.fabia.campanario.Models;

/**
 * Created by DIEGO on 01/11/2017.
 */

public class  ChatMo {

    private String message;
    private boolean isSend;

    public ChatMo(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public ChatMo() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
