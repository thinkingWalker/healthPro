package com.example.hanlu.healthyadvisor.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/6/24  14:36
 *
 * @desc
 */
public class KnowledgeListInfo implements ListEntity<KnowledgeDetailInfo.ResultEntity> {

    private List<KnowledgeDetailInfo.ResultEntity> knowledgeDetailInfos = new ArrayList<KnowledgeDetailInfo.ResultEntity>();

    @Override
    public List<KnowledgeDetailInfo.ResultEntity> getList() {
        return knowledgeDetailInfos;
    }

    public List<KnowledgeDetailInfo.ResultEntity> getKnowledgeDetailInfos() {
        return knowledgeDetailInfos;
    }

    public void setKnowledgeDetailInfos(List<KnowledgeDetailInfo.ResultEntity> knowledgeDetailInfos) {
        this.knowledgeDetailInfos = knowledgeDetailInfos;
    }
}
