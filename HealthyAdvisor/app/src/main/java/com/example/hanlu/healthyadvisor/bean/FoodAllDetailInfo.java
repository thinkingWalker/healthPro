package com.example.hanlu.healthyadvisor.bean;

import java.io.Serializable;

/**
 * Created by hanlu on 2016/3/10.
 */
public class FoodAllDetailInfo  implements Serializable{

    /**
     * id : 11
     * description : 生物学特性白虾属已知共有6种,都分布在印度洋-西太平洋地区温暖海域或淡水中
     * disease :
     * food :
     * img : http://api.avatardata.cn/Food/Img?file=1b112c7583204ff4b5d11d85b9c1fab6.jpg
     * keywords : 西太平洋 甲壳动物 印度洋 生物学 长臂虾
     * message : 白刺虾，十足目(Decapoda)长臂虾科(Palaemonidae)白虾属(Exopalaemon)甲壳动物的统称。因甲壳较薄、色素细胞少，平时身体透明，死后肌肉呈白色，故名。生物学特性白虾属已知共有6种,都分布在印度洋-西太平洋地区温暖海域或淡水中。
     * name : 白刺虾
     * summary :
     * fcount : 0
     * rcount : 0
     * count : 278
     */

    private ResultEntity result;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public ResultEntity getResult() {
        return result;
    }

    public static class ResultEntity implements Serializable{
        private int id;
        private String description;
        private String disease;
        private String food;
        private String img;
        private String keywords;
        private String message;
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

        public void setMessage(String message) {
            this.message = message;
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

        public String getMessage() {
            return message;
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
