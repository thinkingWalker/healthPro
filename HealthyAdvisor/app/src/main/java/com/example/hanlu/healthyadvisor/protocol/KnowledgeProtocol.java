package com.example.hanlu.healthyadvisor.protocol;

import android.util.Log;

import com.example.hanlu.healthyadvisor.bean.KnowledgeInfo;
import com.example.hanlu.healthyadvisor.bean.KnowledgeListInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/6.
 */
public class KnowledgeProtocol extends BaseProtocol<KnowledgeInfo>{
    private static final String TAG = "tag";

    @Override
    protected KnowledgeInfo parseJson(String json) {
        Gson gson=new Gson();
        KnowledgeInfo knowledgeInfo = gson.fromJson(json, KnowledgeInfo.class);
        Log.i(TAG, "parseJson: "+knowledgeInfo);
        return knowledgeInfo;
    }

    @Override
    protected String getKey() {
        return Constant.KNOEWLEDGE_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.KNOWLEDGE_BASE_URL;
    }
}
