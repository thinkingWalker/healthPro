package com.example.hanlu.healthyadvisor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.adapter.KnowledgeDetailActivity;
import com.example.hanlu.healthyadvisor.adapter.LoseWeightAdapter;
import com.example.hanlu.healthyadvisor.base.BaseListFragment;
import com.example.hanlu.healthyadvisor.base.ListBaseAdapter;
import com.example.hanlu.healthyadvisor.bean.HealthInfo;
import com.example.hanlu.healthyadvisor.bean.HealthyListInfo;
import com.example.hanlu.healthyadvisor.bean.KnowledgeDetailInfo;
import com.example.hanlu.healthyadvisor.bean.ListEntity;
import com.example.hanlu.healthyadvisor.protocol.HealthyApi;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Admin on 2016/6/24  10:44
 *
 * @desc
 */
public class LoseWeightFragment extends BaseListFragment<HealthInfo> {


    private HealthyListInfo healthyListInfo;
    private ArrayList<HealthInfo> data;

    @Override
    protected LoseWeightAdapter getListAdapter() {
        LoseWeightAdapter loseWeightAdapter = new LoseWeightAdapter(getContext());
        data = loseWeightAdapter.getData();
        return loseWeightAdapter;
    }

    @Override
    protected HealthyListInfo parseList(byte[] is) throws Exception {
        healthyListInfo = HealthyKnowledgeJsonUtils.formatJson(is);

        return healthyListInfo;
    }

    @Override
    protected String getCacheKeyPrefix() {
        return "loseWeight_";
    }


    @Override
    protected ListEntity<HealthInfo> readList(Serializable seri) {
        return (HealthyListInfo)seri;
    }

    @Override
    protected void sendRequestData() {
        HealthyApi.getHealthyInfo(getContext(),11,mCurrentPage,mHandler);
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

