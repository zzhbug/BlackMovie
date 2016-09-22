package com.zzh.blackmovie.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DiscoverTagAll {

    /**
     * message : 获取 20条数据
     * content : [{"categoryId":15,"categoryName":"动物","categoryzdName":"动物","positoin":0,"page_code":"\"\"","type":0},{"categoryId":7,"categoryName":"悬疑","categoryzdName":"悬疑","positoin":0,"page_code":"\"\"","type":0},{"categoryId":66,"categoryName":"人性","categoryzdName":"人性","positoin":0,"page_code":"\"\"","type":0},{"categoryId":67,"categoryName":"末日","categoryzdName":"末日","positoin":0,"page_code":"\"\"","type":0},{"categoryId":14,"categoryName":"丧尸","categoryzdName":"丧尸","positoin":0,"page_code":"S","type":0},{"categoryId":18,"categoryName":"驱魔","categoryzdName":"驱魔","positoin":0,"page_code":"S3","type":0},{"categoryId":11,"categoryName":"诅咒","categoryzdName":"诅咒","positoin":0,"page_code":"S5","type":0},{"categoryId":13,"categoryName":"食人魔","categoryzdName":"食人魔","positoin":0,"page_code":"S10","type":0},{"categoryId":9,"categoryName":"灵异","categoryzdName":"灵异","positoin":0,"page_code":"S2","type":0},{"categoryId":21,"categoryName":"杀人狂","categoryzdName":"杀人狂","positoin":0,"page_code":"S9","type":0},{"categoryId":6,"categoryName":"病毒","categoryzdName":"病毒","positoin":0,"page_code":"S6","type":0},{"categoryId":8,"categoryName":"吸血鬼","categoryzdName":"吸血鬼","positoin":0,"page_code":"S12","type":0},{"categoryId":16,"categoryName":"密室","categoryzdName":"密室","positoin":0,"page_code":"S13","type":0},{"categoryId":10,"categoryName":"变异","categoryzdName":"变异","positoin":0,"page_code":"S7","type":0},{"categoryId":20,"categoryName":"灾难","categoryzdName":"灾难","positoin":0,"page_code":"S8","type":0},{"categoryId":19,"categoryName":"梦魇","categoryzdName":"梦魇","positoin":0,"page_code":"S4","type":0},{"categoryId":12,"categoryName":"狼人","categoryzdName":"狼人","positoin":0,"page_code":"S1","type":0},{"categoryId":61,"categoryName":"战争","categoryzdName":"战争","positoin":0,"page_code":"\"\"","type":0},{"categoryId":17,"categoryName":"科幻","categoryzdName":"科幻","positoin":0,"page_code":"S14","type":0},{"categoryId":31,"categoryName":"预告片","categoryzdName":"预告片","positoin":1,"page_code":"\"\"","type":0,"productmovieList":[{"id":665,"name":"活死人惊魂夜","type":2,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160804170558-1880509853.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"不良少年与僵尸","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":664,"name":"地狱酒店","type":2,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160804170534-893832550.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《地狱酒店》\r\n山林中的魔鬼住所","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":487,"name":"黑暗之渠","type":2,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160714171622-956015676.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":484,"name":"终点","type":2,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160714110408-1882639173.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1}]}]
     * request : /v2.3/rest/find/getFindResource/1
     * statusCode : 200
     */

    private String message;
    private String request;
    private int statusCode;
    /**
     * categoryId : 15
     * categoryName : 动物
     * categoryzdName : 动物
     * positoin : 0
     * page_code : ""
     * type : 0
     */

    private List<DiscoverMovieContent> content;

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

    public List<DiscoverMovieContent> getContent() {
        return content;
    }

    public void setContent(List<DiscoverMovieContent> content) {
        this.content = content;
    }


}
