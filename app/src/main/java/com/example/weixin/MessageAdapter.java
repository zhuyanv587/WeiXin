package com.example.weixin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends BaseAdapter {
    private List<Message> messages;
    private Context context;

    public MessageAdapter(Context context, ArrayList<Message> msgs) {
    }

    public MessageAdapter(List<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return messages.size();//决定ListView显示数据的条数
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);//获取position位置的数据
    }

    @Override
    public long getItemId(int position) {
        return position;//获取item的索引位置position
    }

    //自定义item的数据及样式，关联message中的每个对象与item_message.xml中每个控件
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null){//首次加载
            //加载item_message.xml
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message,null);
            //获取每个控件
            holder = new ViewHolder();
            holder.ivHeader = convertView.findViewById(R.id.iv_head);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvSubtitle = convertView.findViewById(R.id.tv_subtitle);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            //将holder对象存储到view中
            convertView.setTag(holder);
        }else {//恢复
            holder = (ViewHolder) convertView.getTag();
        }
        //加载数据
        Message msg = messages.get(position);
        holder.ivHeader.setImageResource(msg.getHeaderId());
        holder.tvTitle.setText(msg.getTitle());
        holder.tvSubtitle.setText(msg.getSubTitle());
        holder.tvTime.setText(msg.getTime());

        return convertView;
    }
    //封装item_message.xml中的所有控件
    static class ViewHolder{
        ImageView ivHeader;
        TextView tvTitle;
        TextView tvSubtitle;
        TextView tvTime;
    }
}
