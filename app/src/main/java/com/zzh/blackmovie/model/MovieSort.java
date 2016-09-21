package com.zzh.blackmovie.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class MovieSort {

    /**
     * categoryId : 22
     * categoryName : 南瓜电影周刊app端
     * categoryzdName : 南瓜电影周刊app端
     * positoin : 1
     * page_code : A
     * type : 0
     * productmovieList : [{"id":1027,"name":"六颗子弹","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919173646-320767958.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《六颗子弹》 人命值六颗子弹","movieOtherImageUrl":"http://qn.image.vcinema.com.cn/20160919173704-294691535.png","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1024,"name":"温柔的杀戮","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919165252-1642971350.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《温柔的杀戮》 破败的怀旧中温柔杀戮","movieOtherImageUrl":"http://qn.image.vcinema.com.cn/20160919165305-313082680.png","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1022,"name":"短柄斧2","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919162556-998183227.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《短柄斧2》 各种死法 各种血腥","movieOtherImageUrl":"http://qn.image.vcinema.com.cn/20160919162614-1438186898.png","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1020,"name":"鬼遮眼","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160920100511-888341916.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《鬼遮眼》 双眼是最能圆谎的镜子","movieOtherImageUrl":"http://qn.image.vcinema.com.cn/20160920100524-1017897490.png","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1019,"name":"白昼冷光","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919155818-1458527024.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《白昼冷光》 虎胆老爸助新超人崛起","movieOtherImageUrl":"http://qn.image.vcinema.com.cn/20160919155831-1268382221.png","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1}]
     */

    private int categoryId;
    private String categoryName;
    private String categoryzdName;
    private int positoin;
    private String page_code;
    private int type;
    /**
     * id : 1027
     * name : 六颗子弹
     * type : 1
     * movieImageUrl : http://qn.image.vcinema.com.cn/20160919173646-320767958.png
     * playUrlBy480p :
     * downloadCid :
     * downloadCKey :
     * isDownloadStatus : 0
     * downloadUrl :
     * lfadvert : 《六颗子弹》 人命值六颗子弹
     * movieOtherImageUrl : http://qn.image.vcinema.com.cn/20160919173704-294691535.png
     * is_type : 1
     * tvsetsnumber : 0
     * updateTvsetsnumber : 0
     * parentId : -1
     */

    private List<ProductmovieList> productmovieList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryzdName() {
        return categoryzdName;
    }

    public void setCategoryzdName(String categoryzdName) {
        this.categoryzdName = categoryzdName;
    }

    public int getPositoin() {
        return positoin;
    }

    public void setPositoin(int positoin) {
        this.positoin = positoin;
    }

    public String getPage_code() {
        return page_code;
    }

    public void setPage_code(String page_code) {
        this.page_code = page_code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ProductmovieList> getProductmovieList() {
        return productmovieList;
    }

    public void setProductmovieList(List<ProductmovieList> productmovieList) {
        this.productmovieList = productmovieList;
    }


}
