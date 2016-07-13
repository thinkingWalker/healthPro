package com.example.hanlu.healthyadvisor.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.adapter.FoodAll;
import com.litesuits.common.utils.DialogUtil;
import com.litesuits.common.utils.NotificationUtil;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengRegistrar;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    public int notReadCount;//未读的反馈数量
    private Toolbar toolbar;
    private FrameLayout content;
    private GridView gridView;
    private ViewPager viewPager;
    private String[] stringArray;
    private int[] images;
    private List<ImageView> list;
    private CirclePageIndicator indicator;
    private Handler mHandler;
    private MainGridAdapter mainGridAdapter;

    @Override
    public void init() {
        stringArray = getResources().getStringArray(R.array.grid_name);
        images = new int[]{R.drawable.shipin, R.drawable.recipe, R.drawable.jiankangzhishi, R.drawable.feedback4, R.drawable.feedback
        ,R.drawable.icon};
        list = new ArrayList<ImageView>();
        ImageView imageView1 = new ImageView(this);
        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);

        imageView1.setImageResource(R.drawable.fm1);
        imageView2.setImageResource(R.drawable.fm2);
        imageView3.setImageResource(R.drawable.fm3);
        list.add(imageView1);
        list.add(imageView2);
        list.add(imageView3);
        //初始化友盟推送
        PushAgent mPushAgent = PushAgent.getInstance(this);


        //开启推送并设置注册的回调处理
        mPushAgent.enable();
        String device_token = UmengRegistrar.getRegistrationId(this);


        //百川消息的数量
        FeedbackAPI.getFeedbackUnreadCount(this, null, new IWxCallback() {

            @Override
            public void onSuccess(Object... objects) {
                Integer i = (Integer) objects[0];
                int notReadCount = i.intValue();
                MainActivity.this.notReadCount = notReadCount;
                Log.i("notReadCount", "onSuccess: "+notReadCount);
                SharedPreferences sp = getSharedPreferences("feedback_notread_count", MODE_PRIVATE);
                sp.edit().putInt("not_read", notReadCount).commit();
            }


            @Override
            public void onError(int i, String s) {
            }

            @Override
            public void onProgress(int i) {
            }
        });

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        gridView = (GridView) findViewById(R.id.main_grid);
        ImageView imageView = (ImageView) findViewById(R.id.main_vp);
        mainGridAdapter = new MainGridAdapter();
        gridView.setAdapter(mainGridAdapter);
        imageView.setImageResource(R.drawable.fm1);
    }


    public void dialogShow() {

        DialogUtil.dialogBuilder(this, "提示", "您确定要提出吗")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();

    }

    @Override
    public void setClickLitener() {
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getActionBar();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            dialogShow();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, NutritionRecipe.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, FoodAll.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, HealthyKnowleage.class));
                break;
            case 3:
                FeedbackAPI.openFeedbackActivity(this);
                //把消息职位0
                SharedPreferences sp = getSharedPreferences("feedback_notread_count", MODE_PRIVATE);
                sp.edit().putInt("not_read", 0).commit();
                mainGridAdapter.notifyDataSetChanged();
                break;
            case 4:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, CommunicateActivity.class));
                break;


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

    private class MainGridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(MainActivity.this, R.layout.view_grid_item, null);
            TextView messageCount = (TextView) view.findViewById(R.id.grid_item_message);
            SharedPreferences sp = getSharedPreferences("feedback_notread_count", MODE_PRIVATE);
            int not_read = sp.getInt("not_read", 0);
            messageCount.setVisibility(View.GONE);
            //显示未读反馈
            if (position == 3) {
                if (not_read > 0) {
                    messageCount.setVisibility(View.VISIBLE);
                    messageCount.setText(notReadCount + "");
                } else {
                    messageCount.setVisibility(View.GONE);
                }
            }
            if (position==4){
                new MaterialShowcaseView.Builder(MainActivity.this)
                        .setTarget(view)
                        .setDismissText("确定")
                        .setContentText("点击了解我")
                        .setDelay(10) // optional but starting animations immediately in onCreate can make them choppy
                        .singleUse("btn") // provide a unique ID used to ensure it is only shown once
                        .show();
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.grid_item_image);
            TextView textView = (TextView) view.findViewById(R.id.grid_item_word);
            imageView.setImageResource(images[position]);
            textView.setText(stringArray[position]);
            return view;
        }
    }

}
