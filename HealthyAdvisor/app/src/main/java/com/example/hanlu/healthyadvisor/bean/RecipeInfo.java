package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by hanlu on 2016/3/5.
 * 营养配餐的javabean类
 */
public class RecipeInfo {


    /**
     * id : 101142
     * description : 蛤蜊提前用淡盐水浸泡吐出沙泥后，锅中放水和姜片烧开后，倒入蛤蜊，大概煮一分钟左右，看到蛤蜊张开，立刻捞出
     * name : 蛤蜊炒年糕
     * food : 年糕,蛤蜊,冬笋,胡萝卜,莴笋
     * img : http://api.avatardata.cn/Cook/Img?file=2489198731f9406f8c6b58e7874c313a.jpg
     * keywords : 蛤蜊 胡萝卜 倒入 翻炒 莴笋
     * count : 4
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        String message;
        int fcount;
        int rount;
        private int id;
        private String description;
        private String name;
        private String food;
        private String img;
        private String keywords;

        public String getMessage() {
            return message;
        }

        public int getFcount() {
            return fcount;
        }

        public int getRount() {
            return rount;
        }

        private int count;

        public void setId(int id) {
            this.id = id;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setName(String name) {
            this.name = name;
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

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getName() {
            return name;
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

        public int getCount() {
            return count;
        }
    }
}
