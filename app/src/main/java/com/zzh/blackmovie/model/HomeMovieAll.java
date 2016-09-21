package com.zzh.blackmovie.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HomeMovieAll {

    /**
     * message : 获取 10条数据
     * content : []
     * request : /v2.3/rest/home/getHomeResource/1/0/10
     * statusCode : 200
     */

    private String message;
    private String request;
    private int statusCode;
    private List<MovieSort> content;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<MovieSort> getContent() {
        return content;
    }

    public void setContent(List<MovieSort> content) {
        this.content = content;
    }
}


