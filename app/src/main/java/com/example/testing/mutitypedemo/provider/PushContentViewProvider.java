package com.example.testing.mutitypedemo.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testing.mutitypedemo.R;
import com.example.testing.mutitypedemo.mutimodel.MultiPushContent;
import com.example.testing.mutitypedemo.viewmodel.PushHeader;
import com.example.testing.mutitypedemo.viewmodel.PushItem;

import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by ZhangYige on 2016/12/20.
 */

public class PushContentViewProvider extends ItemViewProvider<MultiPushContent, PushContentViewProvider.ViewHolder> {
    private Context context;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.item_push_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MultiPushContent multiPushContent) {
        holder.mTextSendtime.setText(multiPushContent.getSendTime());
        Items items = new Items();
        items.add(multiPushContent.getPushHeader());
        for (PushItem pushItem : multiPushContent.getPushItemList()) {
            items.add(pushItem);
        }
        MultiTypeAdapter adapter = new MultiTypeAdapter(items);
        adapter.register(PushHeader.class, new PushHeaderViewProvider());
        adapter.register(PushItem.class, new PushItemViewProvider());
        holder.mRecyclerPushMessageList.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.mRecyclerPushMessageList.setLayoutManager(linearLayoutManager);
        holder.mRecyclerPushMessageList.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextSendtime;//发送时间
        private RecyclerView mRecyclerPushMessageList;//推送消息列表

        public ViewHolder(View itemView) {
            super(itemView);
            mTextSendtime = (TextView) itemView.findViewById(R.id.text_sendtime);
            mRecyclerPushMessageList = (RecyclerView) itemView.findViewById(R.id.recycler_push_message_list);
        }
    }
}
