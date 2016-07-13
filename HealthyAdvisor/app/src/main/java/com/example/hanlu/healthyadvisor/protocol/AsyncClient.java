package com.example.hanlu.healthyadvisor.protocol;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Admin on 2016/6/22  14:24
 *
 * @desc
 */
public class AsyncClient  {
    public static AsyncHttpClient client;

    /**
     * get请求 带参数
     * @param context
     * @param url
     * @param params
     * @param handler
     */
    public static void get(Context context,String url,RequestParams params,AsyncHttpResponseHandler handler){
        Log.i("url", "get: "+url+params);
        client.get(context,url,params,handler);
    }

    /**
     * post的请求  带参数
     * @param context
     * @param url
     * @param params
     * @param handler
     */
    public static void post(Context context,String url,RequestParams params,AsyncHttpResponseHandler handler){
        client.post(context, url, params, handler);
    }


    public void setClient(AsyncHttpClient client) {
        this.client=client;
    }
}



