package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by hanlu on 2016/3/5.
 */
public class QueetionListInfo {

    /**
     * id : 2966
     * title : 频繁照镜子也是一种病吗？
     * keywords : 自己 照镜子 很多人 综合症 而且
     * description : 爱美的人士喜欢照镜子，这是能够理解的行为，因为仪容对于一个人的外在是非常重要，但是如果你属于那类频繁照镜子而且又无法忍受自己的缺点那么你就需要小心了
     * img : http://v2.avatardata.cn/Ask/Img?file=cba2c6a4a6d2488d8efeb4196dd1721f.jpg
     * fcount : 0
     * rcount : 0
     * askclass : 2
     * count : 863
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", keywords='" + keywords + '\'' +
                    ", description='" + description + '\'' +
                    ", img='" + img + '\'' +
                    ", fcount=" + fcount +
                    ", rcount=" + rcount +
                    ", askclass=" + askclass +
                    ", count=" + count +
                    ", infoclass=" + infoclass +
                    ", message='" + message + '\'' +
                    ", time=" + time +
                    '}';
        }

        private int id;
        private String title;
        private String keywords;
        private String description;
        private String img;
        private int fcount;
        private int rcount;
        private int askclass;
        private int count;


        //最新的问答需要的
        private int infoclass;
        private String message;
        private long time;



        public int getInfoclass() {
            return infoclass;
        }

        public String getMessage() {
            return message;
        }

        public long getTime() {
            return time;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public void setAskclass(int askclass) {
            this.askclass = askclass;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getDescription() {
            return description;
        }

        public String getImg() {
            return img;
        }

        public int getFcount() {
            return fcount;
        }

        public int getRcount() {
            return rcount;
        }

        public int getAskclass() {
            return askclass;
        }

        public int getCount() {
            return count;
        }
    }
}
