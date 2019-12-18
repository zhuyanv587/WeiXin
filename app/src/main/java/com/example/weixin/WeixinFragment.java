package com.example.weixin;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class WeixinFragment extends Fragment {
    private OnDataCallbackListener listener;
    ArrayList<Message> msgs;
    private ListView LvMsg;
    //构造方法
    public WeixinFragment() {
    }
    //工厂方法
    public static WeixinFragment newInstance() {
        WeixinFragment fragment = new WeixinFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //相当于Activity的onCreate()的功能和作用
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weixin,container,false);
        //显示选项菜单
        setHasOptionsMenu(true);
        initData();
        initView(view);
        Context context = getActivity();
        if (context instanceof OnDataCallbackListener) {
            listener = (OnDataCallbackListener) context;
            // 接口对象是activity的接口上下文
            listener.setActivityTitle(getResources().getString(R.string.btn_weixin));
        }
        return view;
    }

    private void initView(View view) {
        //初始化列表控件
        LvMsg=view.findViewById(R.id.lv_messages);
        //设置列表的适配器
        LvMsg.setAdapter(new MessageAdapter(msgs,getContext()));
        //3.设置每个子项的适配器
        LvMsg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Message msg= (Message) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(),msg.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initData() {
        msgs=new ArrayList<>();
        msgs.add(new Message(R.mipmap.fuwuhao,"服务号消息","[2条]南工院，春天美景","2019/5/1",false));
        msgs.add(new Message(R.mipmap.qunliao,"群聊","Marry,下午去比赛","昨天",true));
        msgs.add(new Message(R.mipmap.head,"else","[1条] 晚上去看妇联4","14:20",false));

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_talk:
                Toast.makeText(getActivity(),item.getTitle(),Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
