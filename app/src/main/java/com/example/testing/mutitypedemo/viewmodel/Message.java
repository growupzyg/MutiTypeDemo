package com.example.testing.mutitypedemo.viewmodel;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class Message {
    private String sendTime;//发送时间
    private Article article;//推送文章
    private PushContent pushContent;//推送内容

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public PushContent getPushContent() {
        return pushContent;
    }

    public void setPushContent(PushContent pushContent) {
        this.pushContent = pushContent;
    }
}
