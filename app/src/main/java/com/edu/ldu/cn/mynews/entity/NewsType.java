package com.edu.ldu.cn.mynews.entity;

import java.io.Serializable;

/**
 * Created by mic on 2017/1/20.
 */

public class NewsType implements Serializable{
    private int id;
    private String title;
    private String url;
    public NewsType(){}
    public NewsType(int id,String title,String url){
        this.id = id;
        this.title = title;
        this.url = url;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
