package com.example.weixin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Find1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    //声明控件
    private String mParam1;
    private TextView tvData;


    public Find1Fragment() {
        // Required empty public constructor
    }
    //工厂方法，传递参数   在fragment里面传递参数不用intent了，用fragment.setArguments
    public static Find1Fragment newInstance(String param1) {
        Find1Fragment fragment = new Find1Fragment();
        //用bundle传参数，args的名字是你自己起的
        Bundle args = new Bundle();
        //用这个bundle的名字来装载这个参数。。2.也可以在这里面直接写上你要写的数据
        args.putString(ARG_PARAM1, param1);
        //发送用set，最后将装载参数的容器通过fragment.setArgument将它传走
        fragment.setArguments(args);
        //返回fragment
        return fragment;
    }
    //（拿到这个参数）获取值，onCreate,只要创建过后的话，onCreateView肯定是存在的
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_find1, container, false);
        //初始化控件和数据,要用view拿到它的id
        tvData=view.findViewById(R.id.tv_data);
        //获取从Activity传递的数据
        if (getArguments() != null) {
            //拿到它，get，  就是拿到你的参数  bundle的对象
            mParam1 = getArguments().getString(ARG_PARAM1);
            //得到它，set
            tvData.setText(mParam1);
        }

        return view;
    }

}
