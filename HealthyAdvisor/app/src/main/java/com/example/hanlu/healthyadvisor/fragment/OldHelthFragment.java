package com.example.hanlu.healthyadvisor.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.adapter.DefaultAdapter;
import com.example.hanlu.healthyadvisor.adapter.KnowledgeDetailActivity;
import com.example.hanlu.healthyadvisor.adapter.LoseWeightAdapter;
import com.example.hanlu.healthyadvisor.base.BaseListFragment;
import com.example.hanlu.healthyadvisor.bean.HealthInfo;
import com.example.hanlu.healthyadvisor.bean.HealthyListInfo;
import com.example.hanlu.healthyadvisor.bean.KnowledgeListInfo;
import com.example.hanlu.healthyadvisor.bean.ListEntity;
import com.example.hanlu.healthyadvisor.holder.BaseHolder;
import com.example.hanlu.healthyadvisor.protocol.HealthyApi;
import com.example.hanlu.healthyadvisor.protocol.KnowledgeListProtocol;
import com.example.hanlu.healthyadvisor.protocol.KnowledgeNewProtocol;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.LoadingView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlu on 2016/3/5.
 */
public class OldHelthFragment extends BaseListFragment<HealthInfo> {


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
        return "oldHealth_";
    }


    @Override
    protected ListEntity<HealthInfo> readList(Serializable seri) {
        return (HealthyListInfo)seri;
    }

    @Override
    protected void sendRequestData() {
        HealthyApi.getHealthyInfo(getContext(), 1, mCurrentPage, mHandler);
    }

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
