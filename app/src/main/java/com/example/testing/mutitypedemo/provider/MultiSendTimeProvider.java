package com.example.testing.mutitypedemo.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.mutimodel.MultiSendTime;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class MultiSendTimeProvider extends ItemViewProvider<MultiSendTime,MultiSendTimeProvider.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_sendtime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MultiSendTime multiSendTime) {
        holder.mTextSendtime.setText(multiSendTime.getSendTime());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextSendtime;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextSendtime = (TextView) itemView.findViewById(R.id.text_sendtime);
        }
    }
}
