package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.KnowledgeDetailInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/9.
 */
public class KnowledgeDetailProtocol extends BaseProtocol<KnowledgeDetailInfo>{
    @Override
    protected KnowledgeDetailInfo parseJson(String json) {
        Gson gson=new Gson();
        KnowledgeDetailInfo knowledgeDetailInfo = gson.fromJson(json, KnowledgeDetailInfo.class);
        return knowledgeDetailInfo;
    }

    @Override
    protected String getKey() {
        return Constant.KNOEWLEDGE_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.KNOWLEDGE_DETAIL_URL;
    }
}
