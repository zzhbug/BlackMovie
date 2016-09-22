package com.zzh.blackmovie.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MovieLikeAll {

    /**
     * message : 获取 10条数据
     * content : [{"id":1025,"name":"短柄斧3","director":"BJ McDonnell","actor":"丹妮尔·哈丽丝,凯恩·霍德尔,扎克·加利根","area":"美国","year":"2013","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919171243-2077425901.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"全片都在贩卖内脏","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1023,"name":"玩命记忆","director":"西蒙·布兰德","actor":"格雷戈·金尼尔 ,布丽姬·穆娜,吉姆·卡维泽 ","area":"美国","year":"2006","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919164408-839687684.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"我们是否都被记忆所累","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1022,"name":"短柄斧2","director":"亚当·格林","actor":"丹妮尔·哈丽丝,托尼·托德 ,凯恩·霍德尔","area":"美国","year":"2010","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919162544-1950590150.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《短柄斧2》 各种死法 各种血腥","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1021,"name":"夺命枪火","director":"Wayne Kramer","actor":"维拉·法米加, 保罗·沃克,卡梅隆·布莱特 ","area":"美国","year":"2006","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919161406-1267396878.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"一把枪引发的火爆夜晚","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1020,"name":"鬼遮眼","director":"迈克·弗拉纳根","actor":"凯缇·萨克霍夫, 凯伦·吉兰,布伦顿·思韦茨 ","area":"美国","year":"2014","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160920100501-205140988.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《鬼遮眼》 双眼是最能圆谎的镜子","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1019,"name":"白昼冷光","director":"马布鲁克·埃尔·梅奇","actor":"西格妮·韦弗,布鲁斯·威利斯,亨利·卡维尔","area":"美国","year":"2012","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919155754-1074194790.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"《白昼冷光》 虎胆老爸助新超人崛起","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1017,"name":"疯羊","director":" Jonathan King","actor":"Matthew Chamberlain,Tammy Davis , Peter Feeney","area":"新西兰","year":"2007","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919143408-1649373809.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"嗜血小绵羊的黑色派对","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1016,"name":"借刀杀人","director":"迈克尔·曼 ","actor":"汤姆·克鲁斯,杰米·福克斯,贾达·萍克·史密斯 ","area":"美国","year":"2004","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919110640-496904455.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"冷面杀手的恻隐时刻","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1014,"name":"艾利之书","director":"艾尔伯特·休斯","actor":"加里·奥德曼,丹泽尔·华盛顿,米拉·库尼斯","area":"美国","year":"2010","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160919143253-443681779.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"一曲忠诚的赞歌","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1},{"id":1012,"name":"最终幻想15：王者之剑","director":"野末武志","actor":"肖恩·宾,亚伦·保尔,琳娜·海蒂","area":"日本","year":"2016","type":1,"movieImageUrl":"http://qn.image.vcinema.com.cn/20160914152003-1520649731.png","playUrlBy480p":"","downloadCid":"","downloadCKey":"","isDownloadStatus":0,"downloadUrl":"","lfadvert":"始终有一颗最终幻想的心","movieOtherImageUrl":"","is_type":1,"tvsetsnumber":0,"updateTvsetsnumber":0,"parentId":-1}]
     * request : /v2.3/rest/movie/queryMovieByRecommend/228893/974
     * statusCode : 200
     */

    private String message;
    private String request;
    private int statusCode;
    /**
     * id : 1025
     * name : 短柄斧3
     * director : BJ McDonnell
     * actor : 丹妮尔·哈丽丝,凯恩·霍德尔,扎克·加利根
     * area : 美国
     * year : 2013
     * type : 1
     * movieImageUrl : http://qn.image.vcinema.com.cn/20160919171243-2077425901.png
     * playUrlBy480p :
     * downloadCid :
     * downloadCKey :
     * isDownloadStatus : 0
     * downloadUrl :
     * lfadvert : 全片都在贩卖内脏
     * movieOtherImageUrl :
     * is_type : 1
     * tvsetsnumber : 0
     * updateTvsetsnumber : 0
     * parentId : -1
     */

    private List<LikeMovie> content;

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

    public List<LikeMovie> getContent() {
        return content;
    }

    public void setContent(List<LikeMovie> content) {
        this.content = content;
    }

    public static class LikeMovie {
        private int id;
        private String name;
        private String director;
        private String actor;
        private String area;
        private String year;
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
}
