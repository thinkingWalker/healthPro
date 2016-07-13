package com.example.hanlu.healthyadvisor.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hanlu on 2016/3/10.
 */
public class FoodAllListInfo implements Serializable {

    @Override
    public String toString() {
        return "FoodAllListInfo{" +
                "result=" + result +
                '}';
    }

    /**
     * id : 1377
     * description : 食材介绍燕麦主产于我国内蒙古、河北、陕西、甘肃、宁夏、东北等地，原为谷物类作物的田间杂草，战国时期才被培育成农作物
     * disease :
     * food :
     * img : http://api.avatardata.cn/Food/Img?file=b65f2466b91043f591f3ef9f99fb929f.jpg
     * keywords : 燕麦 中含有 动脉粥样硬化 丰富 之一
     * name : 燕麦
     * summary :
     <p></p>
     <p>性温、味甘；补虚，止汗。</p>
     <p></p>
     <p></p>
     * fcount : 0
     * rcount : 0
     * count : 118
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity implements Serializable{
        @Override
        public String toString() {
            return "ResultEntity{" +
                    "id=" + id +
                    ", description='" + description + '\'' +
                    ", disease='" + disease + '\'' +
                    ", food='" + food + '\'' +
                    ", img='" + img + '\'' +
                    ", keywords='" + keywords + '\'' +
                    ", name='" + name + '\'' +
                    ", summary='" + summary + '\'' +
                    ", fcount=" + fcount +
                    ", rcount=" + rcount +
                    ", count=" + count +
                    '}';
        }

        private int id;
        private String description;
        private String disease;
        private String food;
        private String img;
        private String keywords;
        private String name;
        private String summary;
        private int fcount;
        private int rcount;
        private int count;

        public void setId(int id) {
            this.id = id;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getDisease() {
            return disease;
        }

        public String getFood() {
            return food;
        }

        public String getImg() {
            return img;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getName() {
            return name;
        }

        public String getSummary() {
            return summary;
        }

        public int getFcount() {
            return fcount;
        }

        public int getRcount() {
            return rcount;
        }

        public int getCount() {
            return count;
        }
    }
}
