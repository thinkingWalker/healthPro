package com.example.hanlu.healthyadvisor.protocol;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Random;

/**
 * Created by Admin on 2016/6/22  14:30
 *网络请求的二次封装
 * @desc
 */
public class HealthyApi  {
    public static final String HEALTHY_INFO_KEY="f94ed831a7d94062bc06bfef903e629a";
    public static final String HEALTHY_INFO_URL="http://api.avatardata.cn/Lore/List";
    public static final String HEALTHY_NEWS_URL="http://api.avatardata.cn/Lore/News";
    public static final String HEALTHY_DETAIL_INFO_URL="http://api.avatardata.cn/Lore/Show";


    /**
     * 获取健康知识的数据
     * @param context
     * @param typeId
     * @param pageIndex
     * @param handler
     */
    public static void getHealthyInfo(Context context,int typeId,int pageIndex,AsyncHttpResponseHandler handler){
        RequestParams params=new RequestParams();
        params.put("key",HEALTHY_INFO_KEY);
        params.put("page",pageIndex);
        params.put("rows",20);
        params.put("id",typeId);
        AsyncClient.get(context,HEALTHY_INFO_URL    ,params,handler);
    }

    public static void getHealthyNewlest(Context context,int classify, int pageIndex, AsyncHttpResponseHandler mHandler) {
        RequestParams params=new RequestParams();
        params.put("key",HEALTHY_INFO_KEY);
        params.put("page",pageIndex);
        params.put("rows",20);
        params.put("classify",classify);
        params.put("id",10);
        AsyncClient.get(context,HEALTHY_NEWS_URL    ,params,mHandler);

    }

    public static void getHealthyDetailInfo(Context context,int id,AsyncHttpResponseHandler mHandler) {
        RequestParams params=new RequestParams();
        params.put("key",HEALTHY_INFO_KEY);
        params.put("id",id);
        AsyncClient.get(context, HEALTHY_DETAIL_INFO_URL, params, mHandler);

    }
}
