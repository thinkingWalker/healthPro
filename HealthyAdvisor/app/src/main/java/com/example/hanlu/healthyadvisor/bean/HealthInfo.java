package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by Admin on 2016/6/29  10:35
 *
 * @desc
 */
public class HealthInfo extends Entity {
    @Override
    public String toString() {
        return "HealthInfo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", keywords='" + keywords + '\'' +
                ", title='" + title + '\'' +
                ", loreclass=" + loreclass +
                ", time=" + time +
                ", fcount=" + fcount +
                ", count=" + count +
                '}';
    }

        public int id;
        public String description;
        public String img;
        public String keywords;
        public String title;
        public int loreclass;
        public long time;
        public int fcount;
        public int count;

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
