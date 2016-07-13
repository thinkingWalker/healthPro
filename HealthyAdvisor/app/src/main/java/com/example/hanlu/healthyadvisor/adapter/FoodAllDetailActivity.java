package com.example.hanlu.healthyadvisor.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.activity.BaseActivity;
import com.example.hanlu.healthyadvisor.bean.FoodAllDetailInfo;
import com.example.hanlu.healthyadvisor.bean.FoodAllListInfo;
import com.example.hanlu.healthyadvisor.protocol.FooadAllDetailProtocol;
import com.example.hanlu.healthyadvisor.utils.ACache;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.EmptyLayout;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by hanlu on 2016/3/10.
 */
public class FoodAllDetailActivity extends AppCompatActivity {
    public static final String url="http://api.avatardata.cn/Food/Show";
    public static final String key="ca7f16de78a2464292d19b2cde46038b";
    private int myID;
    private TextView name;
    private TextView desc;
    private ImageView imageView;
    WebView webview;
    private ACache mCache;
    private FoodAllDetailInfo.ResultEntity result;
    private EmptyLayout empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCache = ACache.get(this);
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id", 1);
        this.myID=id;
        initView();
        getData();//获取数据
    }

    private void initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.activity_food_all_detail, null);
        setContentView(view);
         name = (TextView) view.findViewById(R.id.foodall_detail_title);
         desc = (TextView) view.findViewById(R.id.foodall_detail_des);
         imageView = (ImageView) view.findViewById(R.id.detail_image);
        empty = (EmptyLayout) findViewById(R.id.empty_layout);
        empty.setOnLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        empty.setErrorType(EmptyLayout.NETWORK_LOADING);


//        utils.display(imageView, result.getImg());
        ImageView back= (ImageView) view.findViewById(R.id.default_icon);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         webview = (WebView) view.findViewById(R.id.message);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);//让支持javascript
    }

    private void getData() {
        FoodAllDetailInfo allDetailInfo = (FoodAllDetailInfo) mCache.getAsObject("FoodAllDetailInfo" + myID);
        if (allDetailInfo!=null){
            //读取本地
            Log.i("allDetailInfo", "getData: "+"bendi");
            showSuccessView(allDetailInfo);
        }else {
            requestNetwork();
            Log.i("allDetailInfo", "getData: " + "netw");
        }
    }

    private void requestNetwork() {
        OkHttpUtils.get()
                .url(url)
                .addParams("key",key)
                .addParams("id",String.valueOf(myID))
                .build()
                .execute(new FoodDetailCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        empty.setErrorType(EmptyLayout.NETWORK_ERROR);

                    }
                    @Override
                    public void onResponse(FoodAllDetailInfo response, int id) {
                        mCache.put("FoodAllDetailInfo"+myID, response, 60 * 60 * 24);
                        showSuccessView(response);
                    }
                });
    }

    private void showSuccessView(FoodAllDetailInfo response) {
        empty.setErrorType(EmptyLayout.HIDE_LAYOUT);

        this.result=response.getResult();
        name.setText(result.getName());
        desc.setText("关键词：" + result.getKeywords());
        webview.loadDataWithBaseURL("", result.getMessage(), "text/html", "utf-8", "");

//        utils.display(imageView, result.getImg());

        webview.loadDataWithBaseURL("", result.getMessage(), "text/html", "utf-8", "");
    }

    public abstract class FoodDetailCallback extends Callback<FoodAllDetailInfo> {
        @Override
        public FoodAllDetailInfo parseNetworkResponse(Response response, int id) throws Exception {
            {
                Gson gson = new Gson();
                FoodAllDetailInfo foodAllDetailInfo = gson.fromJson(response.body().string(), FoodAllDetailInfo.class);
                Log.i("gson", "parseNetworkResponse: " + foodAllDetailInfo.toString());
                return foodAllDetailInfo;
            }
        }
    }


    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
