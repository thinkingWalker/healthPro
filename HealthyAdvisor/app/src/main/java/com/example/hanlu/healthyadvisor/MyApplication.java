package com.example.hanlu.healthyadvisor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.example.hanlu.healthyadvisor.protocol.AsyncClient;
import com.loopj.android.http.AsyncHttpClient;
import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.bmob.v3.Bmob;
import okhttp3.OkHttpClient;

/**
 * Created by hanlu on 2016/3/5.
 */
public class MyApplication extends Application {
    private static Context context;
    private static Handler handler;
    private static int tId;

    public static Handler getHandler() {
        return handler;
    }

    public static int gettId() {

        return tId;
    }

    public static Context getContext() {
        return context;
    }

    public static Activity getActivity() {
        return getActivity();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        tId = android.os.Process.myTid();

        //初始化bmob
        Bmob.initialize(this, "8daca560c32ee44ef7c04166d38905cc");
        //设置client
        AsyncHttpClient client = new AsyncHttpClient();
        AsyncClient asyncClient = new AsyncClient();
        asyncClient.setClient(client);

        //初始化okhttp
        initOkHttp();

        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        //初始化反馈
        FeedbackAPI.initAnnoy(this, "23390236");
    }

    private void initOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

}
