package com.example.hanlu.healthyadvisor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hanlu.healthyadvisor.R;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by Admin on 2016/7/4  15:06
 *
 * @desc
 */
public class AboutActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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
