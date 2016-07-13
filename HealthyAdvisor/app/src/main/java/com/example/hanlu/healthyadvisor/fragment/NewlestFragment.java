package com.example.hanlu.healthyadvisor.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.hanlu.healthyadvisor.adapter.KnowledgeDetailActivity;
import com.example.hanlu.healthyadvisor.adapter.LoseWeightAdapter;
import com.example.hanlu.healthyadvisor.adapter.NewlestAdapter;
import com.example.hanlu.healthyadvisor.base.BaseListFragment;
import com.example.hanlu.healthyadvisor.base.ListBaseAdapter;
import com.example.hanlu.healthyadvisor.bean.HealthInfo;
import com.example.hanlu.healthyadvisor.bean.HealthyListInfo;
import com.example.hanlu.healthyadvisor.bean.ListEntity;
import com.example.hanlu.healthyadvisor.protocol.HealthyApi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hanlu on 2016/6/29.
 */
public class NewlestFragment extends BaseListFragment<HealthInfo> {


    private ArrayList<HealthInfo> data;

    @Override
    protected LoseWeightAdapter getListAdapter() {
        LoseWeightAdapter loseWeightAdapter = new LoseWeightAdapter(getContext());
        data = loseWeightAdapter.getData();
        return loseWeightAdapter;
    }
    @Override
    protected HealthyListInfo parseList(byte[] is) throws Exception {

        return HealthyKnowledgeJsonUtils.formatJson(is);
    }

    @Override
    protected String getCacheKeyPrefix() {
        return "newlest";
    }


    @Override
    protected ListEntity<HealthInfo> readList(Serializable seri) {
        return (HealthyListInfo)seri;
    }

    @Override
    protected void sendRequestData() {
        HealthyApi.getHealthyNewlest(getContext(), classify++, mCurrentPage, mHandler);
    }

    private int classify=1;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getContext(), KnowledgeDetailActivity.class);
        if (data!=null){
            int detailId = data.get(position).getId();
            intent.putExtra("id",detailId);
            startActivity(intent);
        }
    }
}
