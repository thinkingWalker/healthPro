package com.example.hanlu.healthyadvisor.protocol;

import android.util.Log;

import com.example.hanlu.healthyadvisor.bean.KnowledgeListInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/6.
 */
public class KnowledgeListProtocol extends BaseProtocol<KnowledgeListInfo>{
    private static final String TAG = "tag";

    @Override
    protected KnowledgeListInfo parseJson(String json) {
        Gson gson=new Gson();
        KnowledgeListInfo knowledgeInfo = gson.fromJson(json, KnowledgeListInfo.class);
        Log.i(TAG, "parseJson: "+knowledgeInfo);
        return knowledgeInfo;
    }

    @Override
    protected String getKey() {
        return Constant.KNOEWLEDGE_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.KNOWLEDGE_LIST_URL;
    }
}
