package com.example.hanlu.healthyadvisor.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.MyUser;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

public class GuideActivity extends BaseActivity implements View.OnClickListener {

    private List<View> images;
    private ImageView btn;


    @Override
    public void init() {
        images = new ArrayList<View>();
        ImageView imageView1=new ImageView(this);
        ImageView imageView2=new ImageView(this);
        View  imageView3=View.inflate(this, R.layout.guide_view3,null);
        imageView1.setBackgroundResource(R.drawable.guide1);
        imageView2.setBackgroundResource(R.drawable.guide2);
        btn = (ImageView) imageView3.findViewById(R.id.guide_btn);
        images.add(imageView1);
        images.add(imageView2);
        images.add(imageView3);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_guide);
      ViewPager  jazzyViewPager = (ViewPager) findViewById(R.id.guide_vp);
//
//        jazzyViewPager.setTransitionEffect(JazzyViewPager.TransitionEffect.Stack);
        jazzyViewPager.setAdapter(new GuideAdapter());
    }

    @Override
    public void setClickLitener() {
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.guide_btn){
            MyUser userInfo = BmobUser.getCurrentUser(MyUser.class);
            if (userInfo!=null){
                //不等于null
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }else {
                startActivity(new Intent(GuideActivity.this,LoginActivity.class));
                finish();
            }



        }
    }

    private class GuideAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(images.get(position));
//            jazzyViewPager.setObjectForPosition(images.get(position), position);

            return images.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
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
