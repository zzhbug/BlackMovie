package com.zzh.blackmovie.db.entity;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class JsonEntity {

    private int id;
    private long time;
    private String url;
    private String jsonData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
