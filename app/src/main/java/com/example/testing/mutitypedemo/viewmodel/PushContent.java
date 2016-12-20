package com.example.testing.mutitypedemo.viewmodel;

import java.util.List;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class PushContent {
    private PushHeader pushHeader;//推送头条目
    private List<PushItem> pushItemList;//推送条目列表

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
