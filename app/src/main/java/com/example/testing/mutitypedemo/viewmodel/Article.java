package com.example.testing.mutitypedemo.viewmodel;

/**
 * Created by ZhangYige on 2016/12/20.
 * 文章实体
 */

public class Article {
    private String title;//标题
    private String datetime;//日期
    private String content;//文章内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
