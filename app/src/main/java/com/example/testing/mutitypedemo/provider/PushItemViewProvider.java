package com.example.testing.mutitypedemo.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.viewmodel.PushItem;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class PushItemViewProvider extends ItemViewProvider<PushItem, PushItemViewProvider.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_push_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PushItem pushItem) {
        holder.mImageItem.setImageResource(pushItem.getImageId());
        holder.mTextTitle.setText(pushItem.getTitle());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;//标题
        private ImageView mImageItem;//图片

        public ViewHolder(View itemView) {
            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);
            mImageItem = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }
}
