package com.example.testing.mutitypedemo.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.mutimodel.Multi1Article;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class Multi1ArticleViewProvider extends ItemViewProvider<Multi1Article, Multi1ArticleViewProvider.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_article_message1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Multi1Article multi1Article) {
        holder.mTextSendtime.setText(multi1Article.getSendTime());
        holder.mTextArticleTitle.setText(multi1Article.getTitle());
        holder.mTextDatetime.setText(multi1Article.getDatetime());
        holder.mTextArticleContent.setText(multi1Article.getContent());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextSendtime;//发送时间
        private TextView mTextArticleTitle;//发送标题
        private TextView mTextDatetime;//发送日期
        private TextView mTextArticleContent;//发送内容

        public ViewHolder(View itemView) {
            super(itemView);
            mTextSendtime = (TextView) itemView.findViewById(R.id.text_sendtime);
            mTextArticleTitle = (TextView) itemView.findViewById(R.id.text_article_title);
            mTextDatetime = (TextView) itemView.findViewById(R.id.text_datetime);
            mTextArticleContent = (TextView) itemView.findViewById(R.id.text_article_content);
        }
    }
}
