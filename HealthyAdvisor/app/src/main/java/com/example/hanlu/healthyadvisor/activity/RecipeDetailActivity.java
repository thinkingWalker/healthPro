package com.example.hanlu.healthyadvisor.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.activity.BaseActivity;
import com.example.hanlu.healthyadvisor.bean.RecipeDetailInfo;
import com.example.hanlu.healthyadvisor.protocol.RecipeDetailProtocol;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.lidroid.xutils.BitmapUtils;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by hanlu on 2016/3/9.
 */
public class RecipeDetailActivity extends BaseActivity {

    private RecipeDetailInfo.ResultEntity result;

    @Override
    public void initView() {
        LoadingView loadingView = new LoadingView(this) {
            @Override
            protected LoadResult loadData() {
                Intent intent = getIntent();
                int id = intent.getIntExtra("id", 1);
                RecipeDetailProtocol protocol = new RecipeDetailProtocol();
                RecipeDetailInfo load = protocol.load(0, id, 0, 0,null,null,null);
                result = load.getResult();
                return checkData(result);
            }

            @Override
            protected View createSuccessView() {
                View view = View.inflate(UiUtils.getContext(), R.layout.activity_detail_recipe, null);
                TextView title = (TextView) view.findViewById(R.id.recipe_detail_title);
                TextView foods = (TextView) view.findViewById(R.id.recipe_detail_foods);
                title.setText(result.getName());
                foods.setText("关键词：" + result.getKeywords());
                ImageView image = (ImageView) view.findViewById(R.id.detail_image);
                WebView webview = (WebView) view.findViewById(R.id.message);
                String message = result.getMessage();
                BitmapUtils utils = new BitmapUtils(UiUtils.getContext());
                utils.display(image, result.getImg());
                ImageView back= (ImageView) view.findViewById(R.id.default_icon);
                back.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                webview.loadDataWithBaseURL("", message, "text/html", "utf-8", "");
                WebSettings webSettings = webview.getSettings();

                webSettings.setJavaScriptEnabled(true);//让支持javascript
                return view;
            }
        };
        setContentView(loadingView);
        loadingView.loadPage();
    }

    private LoadingView.LoadResult checkData(RecipeDetailInfo.ResultEntity result) {
        if (result == null) {
            return LoadingView.LoadResult.ERROR;
        } else {
            return LoadingView.LoadResult.SUCCESS;
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
