package com.example.testing.mutitypedemo.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.viewmodel.PushHeader;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class PushHeaderViewProvider extends ItemViewProvider<PushHeader, PushHeaderViewProvider.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_push_header, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PushHeader pushHeader) {
        holder.mImageHeader.setImageResource(pushHeader.getImageId());
        holder.mTextTitle.setText(pushHeader.getTitle());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageHeader;//图片
        private TextView mTextTitle;//标题
        public ViewHolder(View itemView) {
            super(itemView);
            mImageHeader = (ImageView) itemView.findViewById(R.id.image_header);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);
        }
    }
}
