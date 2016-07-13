package com.example.hanlu.healthyadvisor.protocol;

import android.util.Log;

import com.example.hanlu.healthyadvisor.bean.KnowledgeListInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/9.
 */
public class KnowledgeNewProtocol extends BaseProtocol<KnowledgeListInfo> {
    @Override
    protected KnowledgeListInfo parseJson(String json) {

        Gson gson=new Gson();
        KnowledgeListInfo knowledgeInfo = gson.fromJson(json, KnowledgeListInfo.class);
        return knowledgeInfo;
    }

    @Override
    protected String getKey() {
        return Constant.KNOEWLEDGE_KEY;

    }

    @Override
    protected String getUrl() {
        return Constant.KNOWLEDGE_NEW_URL;
    }
}
