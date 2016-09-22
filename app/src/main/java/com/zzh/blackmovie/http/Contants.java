package com.zzh.blackmovie.http;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Contants {
    public static final String HOME_URL_HEAD = "https://apis.vcinema.cn:8445/v2.3/rest/home/getHomeResource/1/0/";
    public static final String HOME_URL_FOOT = "?channels=aph1&appVersion=4.1.0&platform=1";
    public static final String RANK_URL = "https://apis.vcinema.cn:8445/v2.3/rest/movie/getMovieByRanking/1/0/100?channels=aph1&appVersion=4.1.0&platform=1";
    public static final String PLAY_HEAD_URL="https://apis.vcinema.cn:8445/v2.3/rest/movie/queryMovieById/228893/";
    public static final String PLAY_FOOT_URL="/1?channels=aph1&appVersion=4.1.0&platform=1";
    public static final String LIKE_HEAD_URL="https://apis.vcinema.cn:8445/v2.3/rest/movie/queryMovieByRecommend/228893/";
    public static final String LIKE_FOOT_URL="?channels=aph1&appVersion=4.1.0&platform=1";
    public static final String MORE_MOVIE_HEAD_URL = "https://apis.vcinema.cn:8445/v2.3/rest/movie/getMovieListByCategoryId/228893/";

    public static final String MORE_MOVIE_FOOT_URL = "/0/200/1?channels=aph1&appVersion=4.1.0&platform=1";
    public static final String DISCOVER_URL = "https://apis.vcinema.cn:8445/v2.3/rest/find/getFindResource/1?channels=aph1&appVersion=4.1.0&platform=1";
}
