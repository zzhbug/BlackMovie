package com.zzh.blackmovie.db.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class HistoryMovieEntity extends RealmObject {
    @PrimaryKey()
    private int id;   //文件id
    private String pic;     //电影图片
    private String name;    // 电影名称
    private String country;  // 电影产地
    private String year;      //上映年份
    private String blackLevel;//黑暗指数
    private long playingTime; //播放位置
    private long duration;   //影片长度
    private int sectionNum;  //影片的集数
    private long playDate;    //播放的日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBlackLevel() {
        return blackLevel;
    }

    public void setBlackLevel(String blackLevel) {
        this.blackLevel = blackLevel;
    }

    public long getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(long playingTime) {
        this.playingTime = playingTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public long getPlayDate() {
        return playDate;
    }

    public void setPlayDate(long playDate) {
        this.playDate = playDate;
    }
}
