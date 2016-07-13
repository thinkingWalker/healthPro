package com.example.hanlu.healthyadvisor.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hanlu on 2016/3/9.
 */
public class KnowledgeDetailInfo implements Serializable{

    @Override
    public String toString() {
        return "KnowledgeDetailInfo{" +
                "result=" + result +
                '}';
    }

    /**
     * id : 2
     * loreclass : 5
     * description : 类型一：恶性肿瘤患者，由于手术、化疗或放疗有可能损伤卵巢功能；类型二：有可能长期大量接触某些放射线和放射线物质的人群；类型三：由于某种特殊原因暂时不能生育，需在卵巢功能损伤或衰退之前将卵子冷冻以保留卵巢功能，待其有可能生育时再将冷冻卵子解冻受精后移植的人群；类型四：部分人卵巢功能过早衰退而不能生育，需要别人的卵子
     * img : http://api.avatardata.cn/Lore/Img?file=4105c81125074e97a80015c12c6b91ae.jpg
     * keywords : 卵子 冷冻 女性 手术 生育
     * message : <p> <br> </p>
     * title : 哪些人有需要冻卵 哪些人不适合冻卵？
     * time : 1438305219000
     * fcount : 0
     * count : 862
     */




    private ResultEntity result;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public ResultEntity getResult() {
        return result;
    }


    public static class ResultEntity implements Serializable{
        @Override
        public String toString() {
            return "ResultEntity{" +
                    "id=" + id +
                    ", loreclass=" + loreclass +
                    ", description='" + description + '\'' +
                    ", img='" + img + '\'' +
                    ", keywords='" + keywords + '\'' +
                    ", message='" + message + '\'' +
                    ", title='" + title + '\'' +
                    ", time=" + time +
                    ", fcount=" + fcount +
                    ", count=" + count +
                    '}';
        }

        private int id;
        private int loreclass;
        private String description;
        private String img;
        private String keywords;
        private String message;
        private String title;
        private long time;
        private int fcount;
        private int count;



        public void setId(int id) {
            this.id = id;
        }

        public void setLoreclass(int loreclass) {
            this.loreclass = loreclass;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public int getLoreclass() {
            return loreclass;
        }

        public String getDescription() {
            return description;
        }

        public String getImg() {
            return img;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getMessage() {
            return message;
        }

        public String getTitle() {
            return title;
        }

        public long getTime() {
            return time;
        }

        public int getFcount() {
            return fcount;
        }

        public int getCount() {
            return count;
        }
    }
}
