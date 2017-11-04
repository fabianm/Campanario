package com.example.fabia.campanario.Models;

/**
 * Created by DIEGO on 01/11/2017.
 */

public class SimsimiMo {
    public String response;
    public String id;
    public int resul;
    public String msg;

    public SimsimiMo(String reponse, String id, int resul, String msg) {
        this.response = reponse;
        this.id = id;
        this.resul = resul;
        this.msg = msg;
    }

    public SimsimiMo() {
    }

    public String getReponse() {
        return response;
    }

    public void setReponse(String reponse) {
        this.response = reponse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResul() {
        return resul;
    }

    public void setResul(int resul) {
        this.resul = resul;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
