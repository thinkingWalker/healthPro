package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by hanlu on 2016/3/6.
 */
public class KnowledgeInfo  {


    /**
     * id : 11
     * name : 减肥瘦身
     * keywords : 减肥瘦身
     * title : 减肥瘦身
     * description : 减肥瘦身,美丽一生,减肥资讯 瘦身资讯 ,减肥瘦身健康知识,减肥瘦身信息专题
     * seq : 1
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private int id;
        private String name;
        private String keywords;
        private String title;
        private String description;
        private int seq;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getSeq() {
            return seq;
        }
    }
}
