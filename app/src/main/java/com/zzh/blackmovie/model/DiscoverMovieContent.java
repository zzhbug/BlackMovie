package com.zzh.blackmovie.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DiscoverMovieContent {
    private int categoryId;
    private String categoryName;
    private String categoryzdName;
    private int positoin;
    private String page_code;
    private int type;


    public List<ProductmovieList> getProductmovieList() {
        return productmovieList;
    }

    public void setProductmovieList(List<ProductmovieList> productmovieList) {
        this.productmovieList = productmovieList;
    }

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
}