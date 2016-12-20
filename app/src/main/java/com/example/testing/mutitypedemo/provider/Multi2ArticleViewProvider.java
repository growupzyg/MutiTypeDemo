package com.example.testing.mutitypedemo.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.mutimodel.Multi2Article;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class Multi2ArticleViewProvider extends ItemViewProvider<Multi2Article, Multi2ArticleViewProvider.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_article_message2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Multi2Article multi2Article) {
        holder.mTextArticleTitle.setText(multi2Article.getTitle());
        holder.mTextDatetime.setText(multi2Article.getDatetime());
        holder.mTextArticleContent.setText(multi2Article.getContent());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextArticleTitle;//发送标题
        private TextView mTextDatetime;//发送日期
        private TextView mTextArticleContent;//发送内容

        public ViewHolder(View itemView) {
            super(itemView);
            mTextArticleTitle = (TextView) itemView.findViewById(R.id.text_article_title);
            mTextDatetime = (TextView) itemView.findViewById(R.id.text_datetime);
            mTextArticleContent = (TextView) itemView.findViewById(R.id.text_article_content);
        }
    }
}
