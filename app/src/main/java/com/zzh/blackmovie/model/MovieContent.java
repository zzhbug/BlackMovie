package com.zzh.blackmovie.model;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public  class MovieContent {
    private int id;
    private String name;
    private int type;
    private String movieImageUrl;
    private String playUrlBy480p;
    private String downloadCid;
    private String downloadCKey;
    private int isDownloadStatus;
    private String downloadUrl;
    private String lfadvert;
    private String movieOtherImageUrl;
    private int is_type;
    private int tvsetsnumber;
    private int updateTvsetsnumber;
    private int parentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    public String getPlayUrlBy480p() {
        return playUrlBy480p;
    }

    public void setPlayUrlBy480p(String playUrlBy480p) {
        this.playUrlBy480p = playUrlBy480p;
    }

    public String getDownloadCid() {
        return downloadCid;
    }

    public void setDownloadCid(String downloadCid) {
        this.downloadCid = downloadCid;
    }

    public String getDownloadCKey() {
        return downloadCKey;
    }

    public void setDownloadCKey(String downloadCKey) {
        this.downloadCKey = downloadCKey;
    }

    public int getIsDownloadStatus() {
        return isDownloadStatus;
    }

    public void setIsDownloadStatus(int isDownloadStatus) {
        this.isDownloadStatus = isDownloadStatus;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getLfadvert() {
        return lfadvert;
    }

    public void setLfadvert(String lfadvert) {
        this.lfadvert = lfadvert;
    }

    public String getMovieOtherImageUrl() {
        return movieOtherImageUrl;
    }

    public void setMovieOtherImageUrl(String movieOtherImageUrl) {
        this.movieOtherImageUrl = movieOtherImageUrl;
    }

    public int getIs_type() {
        return is_type;
    }

    public void setIs_type(int is_type) {
        this.is_type = is_type;
    }

    public int getTvsetsnumber() {
        return tvsetsnumber;
    }

    public void setTvsetsnumber(int tvsetsnumber) {
        this.tvsetsnumber = tvsetsnumber;
    }

    public int getUpdateTvsetsnumber() {
        return updateTvsetsnumber;
    }

    public void setUpdateTvsetsnumber(int updateTvsetsnumber) {
        this.updateTvsetsnumber = updateTvsetsnumber;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}