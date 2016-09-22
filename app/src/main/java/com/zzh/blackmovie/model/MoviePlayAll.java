package com.zzh.blackmovie.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MoviePlayAll {

    /**
     * message : 获取成功
     * content : {"id":956,"name":"惊心食人族2","director":"Victor Salva","actor":"Jonathan Breck, Nicki Lynn Aycox,Billy Aaron Brown","area":"美国","year":"2003","content":"影片英文名：Jeepers Creepers 2 。长有双翼的食人恶魔再度出现了。它袭击了一座农场，将男主人的小儿子比利掳走，愤怒的父亲与长子杰基在沉默中发誓为亲人报仇\u2026\u2026次日，一支高中校队在比赛结束后乘坐校车返回，于路却被尖锐的飞镖刺破了车胎，年轻人们眼见通讯不畅求助无果，只得慢慢行驶前进，夜里，袭击校车的神秘身影显出了真身，食人恶魔令校车彻底瘫痪，在一片恐慌中开始捕捉车中的人们。与此同时，一直追踪食人恶魔的农场父子终于赶到，他们用自制鱼叉阻击恶魔。由于恶魔每次轮回出可以获得23天在人世的时间，如果能坚持到今夜结束，所有人将成功逃生，学生们与农场父子展开了一场同恶魔的拼杀\u2026\u2026","price":0,"type":1,"facePic":"http://7xq4hn.com2.z0.glb.qiniucdn.com/20160908115956-2104009329.png","movieImageUrl":"http://7xq4hn.com2.z0.glb.qiniucdn.com/20160908115956-2104009329.png","terrorismIndex":"4","playUrlBy480p":"http://store.vcinema.com.cn/newEncode201609/1ee9c62958f4bf1caee6761da3f1867f/480pmedia-3/stream.m3u8","tvPrice":0,"cid":"cid:marlin#Pvcinema_Vyy_215@c6f7817a","cKey":"","downloadCid":"cid:marlin#Pvcinema_Vyy_215@c6f7817a","downloadCKey":"000000000000000000000000000000001723c6549329a1b70ab7a3aa8484deec7e4f3e01f11dfafdb9b80c4fb8a57bcc","isDownloadStatus":1,"downloadUrl":"http://store.vcinema.com.cn/newEncode201609/1ee9c62958f4bf1caee6761da3f1867f/1ee9c62958f4bf1caee6761da3f1867f_D_L_E.mp4","lfadvert":"","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1,"nameAlias":"","englishName":"Jeepers Creepers 2 ","movieDramaImages":[],"isCollectStatus":0}
     * request : /v2.3/rest/movie/queryMovieById/228893/956/1
     * statusCode : 200
     */

    private String message;
    /**
     * id : 956
     * name : 惊心食人族2
     * director : Victor Salva
     * actor : Jonathan Breck, Nicki Lynn Aycox,Billy Aaron Brown
     * area : 美国
     * year : 2003
     * content : 影片英文名：Jeepers Creepers 2 。长有双翼的食人恶魔再度出现了。它袭击了一座农场，将男主人的小儿子比利掳走，愤怒的父亲与长子杰基在沉默中发誓为亲人报仇……次日，一支高中校队在比赛结束后乘坐校车返回，于路却被尖锐的飞镖刺破了车胎，年轻人们眼见通讯不畅求助无果，只得慢慢行驶前进，夜里，袭击校车的神秘身影显出了真身，食人恶魔令校车彻底瘫痪，在一片恐慌中开始捕捉车中的人们。与此同时，一直追踪食人恶魔的农场父子终于赶到，他们用自制鱼叉阻击恶魔。由于恶魔每次轮回出可以获得23天在人世的时间，如果能坚持到今夜结束，所有人将成功逃生，学生们与农场父子展开了一场同恶魔的拼杀……
     * price : 0
     * type : 1
     * facePic : http://7xq4hn.com2.z0.glb.qiniucdn.com/20160908115956-2104009329.png
     * movieImageUrl : http://7xq4hn.com2.z0.glb.qiniucdn.com/20160908115956-2104009329.png
     * terrorismIndex : 4
     * playUrlBy480p : http://store.vcinema.com.cn/newEncode201609/1ee9c62958f4bf1caee6761da3f1867f/480pmedia-3/stream.m3u8
     * tvPrice : 0
     * cid : cid:marlin#Pvcinema_Vyy_215@c6f7817a
     * cKey :
     * downloadCid : cid:marlin#Pvcinema_Vyy_215@c6f7817a
     * downloadCKey : 000000000000000000000000000000001723c6549329a1b70ab7a3aa8484deec7e4f3e01f11dfafdb9b80c4fb8a57bcc
     * isDownloadStatus : 1
     * downloadUrl : http://store.vcinema.com.cn/newEncode201609/1ee9c62958f4bf1caee6761da3f1867f/1ee9c62958f4bf1caee6761da3f1867f_D_L_E.mp4
     * lfadvert :
     * movieOtherImageUrl :
     * is_type : 1
     * tvsetsnumber : 0
     * updateTvsetsnumber : 0
     * parentId : -1
     * nameAlias :
     * englishName : Jeepers Creepers 2
     * movieDramaImages : []
     * isCollectStatus : 0
     */

    private MovieMessage content;
    private String request;
    private int statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MovieMessage getContent() {
        return content;
    }

    public void setContent(MovieMessage content) {
        this.content = content;
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

    public static class MovieMessage {
        private int id;
        private String name;
        private String director;
        private String actor;
        private String area;
        private String year;
        private String content;
        private int price;
        private int type;
        private String facePic;
        private String movieImageUrl;
        private String terrorismIndex;
        private String playUrlBy480p;
        private int tvPrice;
        private String cid;
        private String cKey;
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
        private String nameAlias;
        private String englishName;
        private int isCollectStatus;
        private List<?> movieDramaImages;

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

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getActor() {
            return actor;
        }

        public void setActor(String actor) {
            this.actor = actor;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getFacePic() {
            return facePic;
        }

        public void setFacePic(String facePic) {
            this.facePic = facePic;
        }

        public String getMovieImageUrl() {
            return movieImageUrl;
        }

        public void setMovieImageUrl(String movieImageUrl) {
            this.movieImageUrl = movieImageUrl;
        }

        public String getTerrorismIndex() {
            return terrorismIndex;
        }

        public void setTerrorismIndex(String terrorismIndex) {
            this.terrorismIndex = terrorismIndex;
        }

        public String getPlayUrlBy480p() {
            return playUrlBy480p;
        }

        public void setPlayUrlBy480p(String playUrlBy480p) {
            this.playUrlBy480p = playUrlBy480p;
        }

        public int getTvPrice() {
            return tvPrice;
        }

        public void setTvPrice(int tvPrice) {
            this.tvPrice = tvPrice;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getCKey() {
            return cKey;
        }

        public void setCKey(String cKey) {
            this.cKey = cKey;
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

        public String getNameAlias() {
            return nameAlias;
        }

        public void setNameAlias(String nameAlias) {
            this.nameAlias = nameAlias;
        }

        public String getEnglishName() {
            return englishName;
        }

        public void setEnglishName(String englishName) {
            this.englishName = englishName;
        }

        public int getIsCollectStatus() {
            return isCollectStatus;
        }

        public void setIsCollectStatus(int isCollectStatus) {
            this.isCollectStatus = isCollectStatus;
        }

        public List<?> getMovieDramaImages() {
            return movieDramaImages;
        }

        public void setMovieDramaImages(List<?> movieDramaImages) {
            this.movieDramaImages = movieDramaImages;
        }
    }
}
