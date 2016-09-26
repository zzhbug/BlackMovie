package com.zzh.blackmovie.db.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class JsonEntity extends RealmObject {

    @PrimaryKey
    private long time; //更新的时间

    private String url; //json 数据对于的url

    private String jsonData;


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
