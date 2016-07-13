//package com.example.hanlu.healthyadvisor.activity;
//
//import android.content.Intent;
//import android.view.View;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.hanlu.healthyadvisor.R;
//import com.example.hanlu.healthyadvisor.bean.FoodAllDetailInfo;
//import com.example.hanlu.healthyadvisor.protocol.FooadAllDetailProtocol;
//import com.example.hanlu.healthyadvisor.utils.UiUtils;
//import com.example.hanlu.healthyadvisor.view.LoadingView;
//import com.umeng.analytics.MobclickAgent;
//
///**
// * Created by hanlu on 2016/3/10.
// */
//public class FoodAllDetailActivity extends BaseActivity {
//
//    private FoodAllDetailInfo.ResultEntity result;
//
//    @Override
//    public void initView() {
//        LoadingView loadingView = new LoadingView(this) {
//            @Override
//            protected LoadResult loadData() {
//                Intent intent = getIntent();
//                int id = intent.getExtras().getInt("id", 1);
//                FooadAllDetailProtocol protocol = new FooadAllDetailProtocol();
//                FoodAllDetailInfo load = protocol.load(0, id, 0, 0, null,null,null);
//                result = load.getResult();
//                return checkData(result);
//            }
//
//            @Override
//            protected View createSuccessView() {
//                View view = View.inflate(UiUtils.getContext(), R.layout.activity_food_all_detail, null);
//                TextView name = (TextView) view.findViewById(R.id.foodall_detail_title);
//                TextView desc = (TextView) view.findViewById(R.id.foodall_detail_des);
//                ImageView imageView = (ImageView) view.findViewById(R.id.detail_image);
//                name.setText(result.getName());
//                desc.setText("关键词："+result.getKeywords());
//                utils.display(imageView, result.getImg());
//                ImageView back= (ImageView) view.findViewById(R.id.default_icon);
//
//                back.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finish();
//                    }
//                });
//                WebView webview = (WebView) view.findViewById(R.id.message);
//                webview.loadDataWithBaseURL("", result.getMessage(), "text/html", "utf-8", "");
//                WebSettings webSettings = webview.getSettings();
//
//                webSettings.setJavaScriptEnabled(true);//让支持javascript
//                return view;
//            }
//        };
//        setContentView(loadingView);
//        loadingView.loadPage();
//
//    }
//
//
//    private LoadingView.LoadResult checkData(FoodAllDetailInfo.ResultEntity result) {
//        if (result == null) {
//            return LoadingView.LoadResult.ERROR;
//        } else {
//            return LoadingView.LoadResult.SUCCESS;
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        MobclickAgent.onResume(this);
//    }
//    public void onPause() {
//        super.onPause();
//        MobclickAgent.onPause(this);
//    }
//}
