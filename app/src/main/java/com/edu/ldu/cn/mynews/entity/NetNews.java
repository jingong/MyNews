package com.edu.ldu.cn.mynews.entity;

/**
 * Created by mic on 2017/1/20.
 */

public class NetNews {
    private String ntime;
    private String title;
    private String description;
    private String url;
    private int picUrl;
    public NetNews(){}
    public NetNews(String ntime,String title,String description,String url,int picUrl){
        this.ntime = ntime;
        this.title = title;
        this.description = description;
        this.url = url;
        this.picUrl = picUrl;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public String getNtime() {
        return ntime;
    }

    public void setNtime(String ntime) {
        this.ntime = ntime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
