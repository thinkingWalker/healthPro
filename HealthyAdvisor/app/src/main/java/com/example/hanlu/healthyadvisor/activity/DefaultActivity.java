package com.example.hanlu.healthyadvisor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.RecipeInfo;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.lidroid.xutils.BitmapUtils;
import com.umeng.message.PushAgent;

import java.util.List;

/**
 * Created by hanlu on 2016/3/6.
 */
public abstract class DefaultActivity extends AppCompatActivity {

    public LinearLayout default_content;
    public TextView default_title;
    public BitmapUtils utils;
    public ImageView default_icon;
    public TextView default_icon_name;

    public <T> LoadingView.LoadResult checkData(List<RecipeInfo.ResultEntity> data) {
        Log.i("result", "checkData: " + data);
        if (data.size() == 0) {
            return LoadingView.LoadResult.EMPTY;
        } else if (data == null) {
            return LoadingView.LoadResult.EMPTY;
        } else {
            return LoadingView.LoadResult.SUCCESS;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        //友盟推送
        PushAgent.getInstance(this).onAppStart();

        default_content = (LinearLayout) findViewById(R.id.default_content);
        default_title = (TextView) findViewById(R.id.default_title);
        default_icon = (ImageView) findViewById(R.id.default_icon);
        default_icon_name = (TextView) findViewById(R.id.default_icon_name);

        utils = new BitmapUtils(this);

        init();
        initView();
        initData();
        setOnLitener();
    }

    public void init() {

    }

    protected void setOnLitener() {

    }

    protected void initData() {

    }

    protected abstract void initView();
}
