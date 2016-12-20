package com.example.testing.mutitypedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testing.mutitypedemo.adapter.MessageListAdapter;
import com.example.testing.mutitypedemo.viewmodel.Article;
import com.example.testing.mutitypedemo.viewmodel.Message;
import com.example.testing.mutitypedemo.viewmodel.PushContent;
import com.example.testing.mutitypedemo.viewmodel.PushHeader;
import com.example.testing.mutitypedemo.viewmodel.PushItem;

import java.util.ArrayList;
import java.util.List;

public class GeneralWayActivity extends AppCompatActivity {
    private RecyclerView mRecyclerMessageList;//消息列表
    private MessageListAdapter mMessageListAdapter;
    private List<Message> mMessageList = new ArrayList<>();

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
        mMessageListAdapter = new MessageListAdapter(mMessageList);
        mRecyclerMessageList.setAdapter(mMessageListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerMessageList.setLayoutManager(linearLayoutManager);
    }

    private void mockData() {
        for (int i = 0; i < 3; i++) {
            Message message = new Message();
            if (i == 0) {
                message.setSendTime("12月17日 早上09:15");
                Article article = new Article();
                article.setTitle("您有一条新消息");
                article.setDatetime("12月17日");
                article.setContent("尊敬的客户：我们已往您的账户汇入100万人民币，请您尽快访问www.woshipianzi.com进行查收，\n账号：youarefoolish 密码：123456");
                message.setArticle(article);
            } else if (i == 1) {
                message.setSendTime("12月18日 早上10:32");
                PushContent pushContent = new PushContent();
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
                message.setPushContent(pushContent);

            } else if (i == 2) {
                message.setSendTime("14:01");
                Article article = new Article();
                article.setTitle("您中大奖啦");
                article.setDatetime("12月20日");
                article.setContent("you are so lucky 哈哈");
                message.setArticle(article);
            }
            mMessageList.add(message);
        }
    }
}
