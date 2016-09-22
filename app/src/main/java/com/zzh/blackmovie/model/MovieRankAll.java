package com.zzh.blackmovie.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class MovieRankAll {

    /**
     * categoryId : 30
     * categoryName : 新版排行榜
     * categoryzdName : 排行
     * positoin : 1
     * type : 0
     * productmovieList : [{"id":956,"name":"惊心食人族2","type":1,"movieImageUrl":"http://7xq4hn.com2.z0.glb.qiniucdn.com/20160908115956-2104009329.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"苍蝇袭人案","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1002,"name":"弯刀","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160914121320-568366614.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"杀机四伏 凶险非常","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":41,"name":"极速复仇","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160422153156-14534343.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"地狱囚徒的末日狂杀","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":983,"name":"杀死比尔","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160913110923-1621384379.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"电影中的另类经典","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":327,"name":"恶之教典","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160622100907-1128664393.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"老师你好坏 不要这样","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":968,"name":"鬣狗之路 ","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160909132919-1557765736.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"伪记录式的战争片","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":732,"name":"狙击手：特别行动","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160815173350-889390245.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"狙击手也不再是孤胆英雄","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":686,"name":"炸掉银行经理","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160808155424-952572435.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"银行经理的惊魂遭遇","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":511,"name":"猛鬼街4","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160718115444-2121949904.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"佛莱迪的梦中大战","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":108,"name":"电锯惊魂5","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160422170854-1968107880.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"时间倒数 生死毁灭开始倒数","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1}]
     */

    private List<MovieRankContent> content;

    public List<MovieRankContent> getContent() {
        return content;
    }

    public void setContent(List<MovieRankContent> content) {
        this.content = content;
    }

    public static class MovieRankContent {
        /**
         * id : 956
         * name : 惊心食人族2
         * type : 1
         * movieImageUrl : http://7xq4hn.com2.z0.glb.qiniucdn.com/20160908115956-2104009329.png
         * playUrlBy480p :
         * downloadCid :
         * downloadCKey :
         * isDownloadStatus : 0
         * downloadUrl :
         * lfadvert : 苍蝇袭人案
         * movieOtherImageUrl :
         * is_type : 1
         * tvsetsnumber : 0
         * updateTvsetsnumber : 0
         * parentId : -1
         */

        private List<MovieRank> productmovieList;

        public List<MovieRank> getProductmovieList() {
            return productmovieList;
        }

        public void setProductmovieList(List<MovieRank> productmovieList) {
            this.productmovieList = productmovieList;
        }

        public static class MovieRank {
            private int id;
            private String name;
            private String movieImageUrl;

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

            public String getMovieImageUrl() {
                return movieImageUrl;
            }

            public void setMovieImageUrl(String movieImageUrl) {
                this.movieImageUrl = movieImageUrl;
            }
        }
    }
}
