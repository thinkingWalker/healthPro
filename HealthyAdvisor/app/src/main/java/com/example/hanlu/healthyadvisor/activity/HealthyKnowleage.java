package com.example.hanlu.healthyadvisor.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.KnowledgeInfo;
import com.example.hanlu.healthyadvisor.utils.KnowledgeFragmentFactory;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.umeng.analytics.MobclickAgent;
import com.viewpagerindicator.TitlePageIndicator;
import java.util.List;
/**
 * Created by hanlu on 2016/3/5.
 */
public class HealthyKnowleage extends DefaultActivity {

    private static final String TAG = "tag";
    private ViewPager vp;
    private TitlePageIndicator indicator;
    public static List<KnowledgeInfo.ResultEntity> result;
    private String[] title_array;

    @Override
    public void init() {
        title_array = getResources().getStringArray(R.array.knowledge_title);
    }

    @Override
    public void initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.activity_knowledge, null);
        vp = (ViewPager) view.findViewById(R.id.knowledge_vp);
        indicator = (TitlePageIndicator) view.findViewById(R.id.knowledge_indicator);
        initIndicator();
        vp.setAdapter(new KnowledgeFragmentAdapter(getSupportFragmentManager()));
        indicator.setViewPager(vp);
        default_title.setText("健康知识");
        default_content.addView(view);
    }

    private void initIndicator() {
        indicator.setVisibility(View.VISIBLE);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setBackgroundResource(R.color.background);
        indicator.setFooterIndicatorHeight(3 * density);
        indicator.setFooterLineHeight(0);
        indicator.setPadding(UiUtils.dip2px(5), UiUtils.dip2px(5), UiUtils.dip2px(5), UiUtils.dip2px(5));
        indicator.setTextSize(UiUtils.dip2px(16));
        indicator.setTextColor(getResources().getColor(R.color.wordSecondry));
        indicator.setSelectedColor(getResources().getColor(R.color.mainColor));
        indicator.setSelectedBold(true);
    }


    private class KnowledgeFragmentAdapter extends FragmentPagerAdapter {
        public KnowledgeFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title_array[position];
        }

        @Override
        public Fragment getItem(int position) {


            return KnowledgeFragmentFactory.createFragment(position);
        }

        @Override
        public int getCount() {
            return title_array.length;
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
