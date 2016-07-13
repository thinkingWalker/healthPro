package com.example.hanlu.healthyadvisor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.hanlu.healthyadvisor.R;

/**
 * Created by Admin on 2016/7/13  12:24
 *
 * @desc
 */
public class LiaoLiaoAddActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
        getWindow().setSoftInputMode(mode);
        setContentView(R.layout.activity_add_liaoliao);
        initView();
    }

    private void initView() {

    }


}
