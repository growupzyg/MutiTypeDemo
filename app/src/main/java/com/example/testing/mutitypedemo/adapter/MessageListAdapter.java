package com.example.testing.mutitypedemo.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.utils.RecycleViewDivider;
import com.example.testing.mutitypedemo.viewmodel.Article;
import com.example.testing.mutitypedemo.viewmodel.Message;
import com.example.testing.mutitypedemo.viewmodel.PushContent;

import java.util.List;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class MessageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int ARTICLE_TYPE = 0;//文章类型
    private final static int PUSH_TYPE = 1;//推送类型
    private List<Message> messageList;
    private Context context;

    public MessageListAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        if (viewType == ARTICLE_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_message1, parent, false);
            return new ArticleViewHolder(view);
        } else if (viewType == PUSH_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_push_message, parent, false);
            return new PushMessageViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (getItemViewType(position) == ARTICLE_TYPE) {
            Article article = message.getArticle();
            ((ArticleViewHolder) holder).mTextSendtime.setText(message.getSendTime());
            ((ArticleViewHolder) holder).mTextArticleTitle.setText(article.getTitle());
            ((ArticleViewHolder) holder).mTextDatetime.setText(article.getDatetime());
            ((ArticleViewHolder) holder).mTextArticleContent.setText(article.getContent());
        } else if (getItemViewType(position) == PUSH_TYPE) {
            PushContent pushContent = message.getPushContent();
            ((PushMessageViewHolder) holder).mTextSendtime.setText(message.getSendTime());
            PushItemAdapter pushItemAdapter = new PushItemAdapter(pushContent);
            ((PushMessageViewHolder) holder).mRecyclerPushMessageList.setAdapter(pushItemAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            ((PushMessageViewHolder) holder).mRecyclerPushMessageList.setLayoutManager(layoutManager);
            ((PushMessageViewHolder) holder).mRecyclerPushMessageList.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.VERTICAL));
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        if (message.getArticle() != null) {
            return ARTICLE_TYPE;
        } else if (message.getPushContent() != null) {
            return PUSH_TYPE;
        }
        return ARTICLE_TYPE;
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    private static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextSendtime;//发送时间
        private TextView mTextArticleTitle;//发送标题
        private TextView mTextDatetime;//发送日期
        private TextView mTextArticleContent;//发送内容

        public ArticleViewHolder(View itemView) {
            super(itemView);
            mTextSendtime = (TextView) itemView.findViewById(R.id.text_sendtime);
            mTextArticleTitle = (TextView) itemView.findViewById(R.id.text_article_title);
            mTextDatetime = (TextView) itemView.findViewById(R.id.text_datetime);
            mTextArticleContent = (TextView) itemView.findViewById(R.id.text_article_content);
        }
    }

    private static class PushMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextSendtime;//发送时间
        private RecyclerView mRecyclerPushMessageList;//推送条目列表

        public PushMessageViewHolder(View itemView) {
            super(itemView);
            mTextSendtime = (TextView) itemView.findViewById(R.id.text_sendtime);
            mRecyclerPushMessageList = (RecyclerView) itemView.findViewById(R.id.recycler_push_message_list);
        }
    }
}
