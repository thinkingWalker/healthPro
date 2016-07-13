package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by Admin on 2016/6/29  12:35
 *
 * @desc
 */
public class HeaList  {



    private int total;
    private int error_code;
    private String reason;
    private List<ResultBean> result;
    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int id;
        private String description;
        private String img;
        private String keywords;
        private String title;
        private int loreclass;
        private long time;
        private int fcount;
        private int count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getLoreclass() {
            return loreclass;
        }

        public void setLoreclass(int loreclass) {
            this.loreclass = loreclass;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
