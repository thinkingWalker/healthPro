package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by hanlu on 2016/3/5.
 */
public class QuestionInfo {

    /**
     * description : 健康知识
     * keywords : 健康常识
     * name : 健康常识
     * title : 健康常识
     * id : 1
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
        private String description;
        private String keywords;
        private String name;
        private String title;
        private int id;
        private int seq;
        private int rcount;
        private int fcount;
        private int count;

        public int getRcount() {
            return rcount;
        }

        public int getFcount() {
            return fcount;
        }

        public int getCount() {
            return count;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getDescription() {
            return description;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getName() {
            return name;
        }

        public String getTitle() {
            return title;
        }

        public int getId() {
            return id;
        }

        public int getSeq() {
            return seq;
        }
    }
}
