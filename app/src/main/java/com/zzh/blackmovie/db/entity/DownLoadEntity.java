package com.zzh.blackmovie.db.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DownLoadEntity extends RealmObject {
    @PrimaryKey
    private int id;  // 文件id
    private byte pic;  //图片
    private String name; //名字
    private String loadState;//下载状态
    private String filePath;//路径
    private int sumSize;//总共大小
    private int finishSize;//完成大小
    private String requestUrl;//相关地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getPic() {
        return pic;
    }

    public void setPic(byte pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoadState() {
        return loadState;
    }

    public void setLoadState(String loadState) {
        this.loadState = loadState;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getSumSize() {
        return sumSize;
    }

    public void setSumSize(int sumSize) {
        this.sumSize = sumSize;
    }

    public int getFinishSize() {
        return finishSize;
    }

    public void setFinishSize(int finishSize) {
        this.finishSize = finishSize;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
