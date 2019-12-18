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
import android.widget.TextView;
import android.widget.Toast;


public class FindFragment extends Fragment {
    private OnDataCallbackListener search;
    public FindFragment() {
        // Required empty public constructor
    }
    //工厂方法
    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //把布局添加进来
        View view=inflater.inflate(R.layout.fragment_find,container,false);
        // Inflate the layout for this fragment
        //显示选项菜单
        setHasOptionsMenu(true);
        //fragment向activity传递数据
        Context context=getContext();
        if(context instanceof OnDataCallbackListener){
            search= (OnDataCallbackListener) context;
            if(search!=null){
                //接口对象就是activity的上下文
                search= (OnDataCallbackListener) context;
                //加载这个页面
                search.setActivityTitle(getResources().getString(R.string.btn_faxian));

            }
        }
        return view;
    }
    //把布局拉过来

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_look,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_look:
                Toast.makeText(getActivity(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
