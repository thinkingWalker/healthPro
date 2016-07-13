package com.example.hanlu.healthyadvisor.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.activity.BaseActivity;
import com.example.hanlu.healthyadvisor.bean.KnowledgeDetailInfo;
import com.example.hanlu.healthyadvisor.protocol.HealthyApi;
import com.example.hanlu.healthyadvisor.protocol.KnowledgeDetailProtocol;
import com.example.hanlu.healthyadvisor.utils.ACache;
import com.example.hanlu.healthyadvisor.utils.NetUtils;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.EmptyLayout;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.umeng.analytics.MobclickAgent;

import cz.msebera.android.httpclient.Header;


/**
 * Created by hanlu on 2016/3/9.
 */
public class KnowledgeDetailActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private WebView webview;
    private EmptyLayout mErrorLayout;
    private int id;
    private AsyncHttpResponseHandler mHandler=new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String json = new String(responseBody);
            Log.i("detail", "onSuccess: "+json);
            Gson gson=new Gson();
            KnowledgeDetailInfo knowledgeDetailInfo = gson.fromJson(json, KnowledgeDetailInfo.class);
            Log.i("showview", "onSuccess: "+knowledgeDetailInfo.toString());
            aCache.put("KnowledgeDetailInfo"+id,knowledgeDetailInfo,60*60*24);//保存数据24个小时

            showView(knowledgeDetailInfo);//展示数据
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

        }
    };
    private TextView title;
    private ACache aCache;

    private void showView(KnowledgeDetailInfo knowledgeDetailInfo) {
        if (knowledgeDetailInfo==null) {
            mErrorLayout.setVisibility(View.VISIBLE);
            mErrorLayout.setErrorType(EmptyLayout.NETWORK_ERROR);
        }else {
            mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
            KnowledgeDetailInfo.ResultEntity result = knowledgeDetailInfo.getResult();
            initData(result);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initView();
    }

    public void init() {
        //拿到从上一个界面传过来的id
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        aCache = ACache.get(this);
    }

   public static final String style= "<style type=text/css>p{text-indent: 2em; font-size:40px; font-color: text-align:justify ；margin-top=5px } </style>";

//    public static final String FONT=  "<style type=text/css>body {font-size:4px;｝</style>"
    public String getWebviewBody(String message){
        StringBuffer body = new StringBuffer();
        body.append(style);
//        body.append(FONT);
        body.append(message);
        return body.toString();

    }

    public void initView() {
        View  view = View.inflate(UiUtils.getContext(), R.layout.activity_knowledge_detail, null);
        setContentView(view);
        title = (TextView) view.findViewById(R.id.knowledge_detail_title);
        webview = (WebView) view.findViewById(R.id.message);
        progressBar = (ProgressBar) view.findViewById(R.id.horizontal_progress);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mErrorLayout = (EmptyLayout) view.findViewById(R.id.loading_page);
        mErrorLayout.setOnLayoutClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
                requestData();

            }
        });

        KnowledgeDetailInfo knowldgeDetailCache = (KnowledgeDetailInfo) aCache.getAsObject("KnowledgeDetailInfo"+id);
          if (knowldgeDetailCache==null){
            requestData();//缓存没有就去读取数据
            Log.i("showview", "initView: "+"请求网络");
        }else {
            //有缓存就用缓存
            showView(knowldgeDetailCache);
            Log.i("showview", "initView: " + "读取本地");
        }

    }

    public void requestData(){
        HealthyApi.getHealthyDetailInfo(this,id,mHandler);
    }
    public void initData(KnowledgeDetailInfo.ResultEntity result) {
        title.setText(result.getTitle());
        String message = result.getMessage();
        BitmapUtils utils = new BitmapUtils(UiUtils.getContext());
//                utils.display(image, result.getImg());
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);//让支持javascript
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUseWideViewPort(true);

        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setNeedInitialFocus(false);
        settings.setSupportZoom(true);
        settings.setLoadsImagesAutomatically(true);//自动加载图片
        settings.setCacheMode(WebSettings.LOAD_DEFAULT
                | WebSettings.LOAD_CACHE_ELSE_NETWORK);
        String webviewBody = getWebviewBody(message);

        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        settings.setDefaultFontSize(UiUtils.dip2px(15));
        webview.loadDataWithBaseURL("", webviewBody, "text/html", "utf-8", "");

        //监听加载进度
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setMax(100);
                progressBar.setProgress(newProgress);
                Log.i("progress", newProgress + "newprogress");
            }
        });
        //监听加载完成
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });
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
