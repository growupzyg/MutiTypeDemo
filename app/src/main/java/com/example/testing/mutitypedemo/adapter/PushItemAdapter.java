package com.example.testing.mutitypedemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.viewmodel.PushContent;
import com.example.testing.mutitypedemo.viewmodel.PushHeader;
import com.example.testing.mutitypedemo.viewmodel.PushItem;

import java.util.List;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class PushItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER = 0;//头Item
    private static final int ITEM = 1;//普通Item
    private PushContent mPushContent;

    public PushItemAdapter(PushContent mPushContent) {
        this.mPushContent = mPushContent;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_push_header, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_push_item, parent, false);
            return new ItemViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == HEADER){
            PushHeader pushHeader = mPushContent.getPushHeader();
            ((HeaderViewHolder)holder).mTextTitle.setText(pushHeader.getTitle());
            ((HeaderViewHolder)holder).mImageHeader.setImageResource(pushHeader.getImageId());
        }else if(getItemViewType(position) == ITEM){
            List<PushItem> pushItemList = mPushContent.getPushItemList();
            PushItem pushItem = pushItemList.get(position-1);
            ((ItemViewHolder)holder).mTextTitle.setText(pushItem.getTitle());
            ((ItemViewHolder)holder).mImageItem.setImageResource(pushItem.getImageId());
        }
    }

    @Override
    public int getItemCount() {
        return mPushContent.getPushItemList().size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        } else {
            return ITEM;
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;//头部标题
        private ImageView mImageHeader;//头部图片
        public HeaderViewHolder(View itemView) {
            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);
            mImageHeader = (ImageView) itemView.findViewById(R.id.image_header);
        }
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;//条目标题
        private ImageView mImageItem;//条目图片
        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);
            mImageItem = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }


}
