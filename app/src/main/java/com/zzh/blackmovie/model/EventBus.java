package com.zzh.blackmovie.model;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class EventBus {
    private String msg;

    public EventBus(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
