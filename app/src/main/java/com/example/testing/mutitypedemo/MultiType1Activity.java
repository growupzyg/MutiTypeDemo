package com.example.testing.mutitypedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testing.mutitypedemo.mutimodel.Multi1Article;
import com.example.testing.mutitypedemo.mutimodel.MultiPushContent;
import com.example.testing.mutitypedemo.provider.Multi1ArticleViewProvider;
import com.example.testing.mutitypedemo.provider.PushContentViewProvider;
import com.example.testing.mutitypedemo.viewmodel.PushHeader;
import com.example.testing.mutitypedemo.viewmodel.PushItem;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * MultiType的第一种应用方式 RecyclerView嵌套的方式
 */
public class MultiType1Activity extends AppCompatActivity {
    private RecyclerView mRecyclerMessageList;//消息列表
    private MultiTypeAdapter adapter;
    /* Items 等价于 ArrayList<Object> */
    private Items items = new Items();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);
        initViews();
        dealEvent();
    }

    private void initViews() {
        mRecyclerMessageList = (RecyclerView) findViewById(R.id.recycler_message_list);
    }

    private void dealEvent() {
        mockData();
        adapter = new MultiTypeAdapter(items);
        /* 注册类型和 View 的对应关系 */
        adapter.register(Multi1Article.class, new Multi1ArticleViewProvider());
        adapter.register(MultiPushContent.class, new PushContentViewProvider());
        mRecyclerMessageList.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerMessageList.setLayoutManager(linearLayoutManager);
    }

    private void mockData() {
        /* 模拟加载数据，也可以稍后再加载，然后使用 adapter.notifyDataSetChanged() 刷新列表 */
        Multi1Article article = new Multi1Article();
        article.setSendTime("12月17日 早上09:15");
        article.setTitle("您有一条新消息");
        article.setDatetime("12月17日");
        article.setContent("尊敬的客户：我们已往您的账户汇入100万人民币，请您尽快访问www.woshipianzi.com进行查收，\n账号：youarefoolish 密码：123456");
        items.add(article);


        MultiPushContent pushContent = new MultiPushContent();
        pushContent.setSendTime("12月18日 早上10:32");
        PushHeader pushHeader = new PushHeader();
        pushHeader.setTitle("我市现在处于严重雾霾中！！！");
        pushHeader.setImageId(R.drawable.mai1);
        pushContent.setPushHeader(pushHeader);
        List<PushItem> pushItems = new ArrayList<>();
        PushItem pushItem1 = new PushItem();
        pushItem1.setTitle("治理空气污染 人人有责");
        pushItem1.setImageId(R.drawable.mai2);
        pushItems.add(pushItem1);
        PushItem pushItem2 = new PushItem();
        pushItem2.setTitle("雾霾天气 小妙招");
        pushItem2.setImageId(R.drawable.mai3);
        pushItems.add(pushItem2);
        PushItem pushItem3 = new PushItem();
        pushItem3.setTitle("雾霾天气 注意预防呼吸疾病");
        pushItem3.setImageId(R.drawable.mai4);
        pushItems.add(pushItem3);
        pushContent.setPushItemList(pushItems);
        items.add(pushContent);


        Multi1Article article1 = new Multi1Article();
        article1.setSendTime("14:01");
        article1.setTitle("您中大奖啦");
        article1.setDatetime("12月20日");
        article1.setContent("you are so lucky 哈哈");
        items.add(article1);
    }
}
