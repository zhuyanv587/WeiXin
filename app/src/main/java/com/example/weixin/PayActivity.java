package com.example.weixin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }

    private List<ThreeService> services;
    private void initData(){
        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.xinyongka,"信用卡还款"));
        services.add(new ThreeService(R.mipmap.shouji,"手机充值"));
        services.add(new ThreeService(R.mipmap.licai,"理财通"));
        services.add(new ThreeService(R.mipmap.shenghuo,"生活缴费"));
        services.add(new ThreeService(R.mipmap.chengshi,"城市服务"));
        services.add(new ThreeService(R.mipmap.qbi,"Q币充值"));
        services.add(new ThreeService(R.mipmap.tengxun,"腾讯公益"));
        services.add(new ThreeService(R.mipmap.baoxian,"保险服务"));
        services.add(new ThreeService(R.mipmap.weilidai,"微粒贷借钱"));
        Intent intent = getIntent();
        intent.putExtra("title",intent);
    }
}
