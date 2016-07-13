package com.example.hanlu.healthyadvisor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import com.lidroid.xutils.BitmapUtils;
import com.umeng.message.PushAgent;

/**
 * Created by hanlu on 2016/3/5.
 */
public class BaseActivity extends AppCompatActivity {

    public BitmapUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utils = new BitmapUtils(this);

        //友盟推送
        PushAgent.getInstance(this).onAppStart();

        init();
        initView();
        setClickLitener();
        initData();
    }

    public void initData() {

    }

    public void setClickLitener() {

    }

    public void initView() {

    }

    public void init() {

    }
}
