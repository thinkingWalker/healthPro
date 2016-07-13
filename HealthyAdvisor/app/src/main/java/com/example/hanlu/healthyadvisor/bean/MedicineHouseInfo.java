package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by hanlu on 2016/3/8.
 */
public class MedicineHouseInfo {

    /**
     * id : 79414
     * area : 1
     * address : 北京市海淀区田村路43号56号楼205、207-210室
     * business : 中成药、化学药制剂、抗生素、生化药品、生物制品、体外诊断试剂
     * charge : 张永
     * img : http://api.avatardata.cn/Store/Img?file=3716d58e37754e6ca0d37e657ac46483.jpg
     * leader : 张立峰
     * legal : 张永
     * name : 北京康大时代医药有限公司
     * number : 京AA0100126
     * tel : 010-67024137
     * type : 批发
     * url :
     * waddress : 北京市海淀区田村路43号21号仓库
     * zipcode : 100000
     * supervise : 37
     * x : 116.406
     * y : 39.8889
     * createdate : 1299081600000
     * fcount : 0
     * rcount : 0
     * count : 12
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
        private int area;
        private String address;
        private String business;
        private String charge;
        private String img;
        private String leader;
        private String legal;
        private String name;
        private String number;
        private String tel;
        private String type;
        private String url;
        private String waddress;
        private String zipcode;
        private int supervise;
        private double x;
        private double y;
        private long createdate;
        private int fcount;
        private int rcount;
        private int count;

        public void setId(int id) {
            this.id = id;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setLeader(String leader) {
            this.leader = leader;
        }

        public void setLegal(String legal) {
            this.legal = legal;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setWaddress(String waddress) {
            this.waddress = waddress;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public void setSupervise(int supervise) {
            this.supervise = supervise;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void setCreatedate(long createdate) {
            this.createdate = createdate;
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

        public int getArea() {
            return area;
        }

        public String getAddress() {
            return address;
        }

        public String getBusiness() {
            return business;
        }

        public String getCharge() {
            return charge;
        }

        public String getImg() {
            return img;
        }

        public String getLeader() {
            return leader;
        }

        public String getLegal() {
            return legal;
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public String getTel() {
            return tel;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public String getWaddress() {
            return waddress;
        }

        public String getZipcode() {
            return zipcode;
        }

        public int getSupervise() {
            return supervise;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public long getCreatedate() {
            return createdate;
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

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "id=" + id +
                    ", area=" + area +
                    ", address='" + address + '\'' +
                    ", business='" + business + '\'' +
                    ", charge='" + charge + '\'' +
                    ", img='" + img + '\'' +
                    ", leader='" + leader + '\'' +
                    ", legal='" + legal + '\'' +
                    ", name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    ", tel='" + tel + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", waddress='" + waddress + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", supervise=" + supervise +
                    ", x=" + x +
                    ", y=" + y +
                    ", createdate=" + createdate +
                    ", fcount=" + fcount +
                    ", rcount=" + rcount +
                    ", count=" + count +
                    '}';
        }
    }

}
