package com.example.testing.mutitypedemo.mutimodel;

import com.example.testing.mutitypedemo.viewmodel.PushHeader;
import com.example.testing.mutitypedemo.viewmodel.PushItem;

import java.util.List;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class MultiPushContent {
    private String sendTime;//发送时间
    private PushHeader pushHeader;//推送头条目
    private List<PushItem> pushItemList;//推送条目列表

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public PushHeader getPushHeader() {
        return pushHeader;
    }

    public void setPushHeader(PushHeader pushHeader) {
        this.pushHeader = pushHeader;
    }

    public List<PushItem> getPushItemList() {
        return pushItemList;
    }

    public void setPushItemList(List<PushItem> pushItemList) {
        this.pushItemList = pushItemList;
    }
}
