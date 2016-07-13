package com.example.hanlu.healthyadvisor.bean;

/**
 * Created by hanlu on 2016/3/9.
 */
public class RecipeDetailInfo {

    /**
     * id : 2
     * description : 菜谱简介材料河虾10只，大蒜2头，盐8克，黑胡椒8克，白酒15ml，酱油10ml，番茄酱10ml，橄榄油30ml做法河虾洗净后剪去虾枪、虾须，在虾背上横着片一刀，深度约为虾肉的三分之二，不要切穿，然后取出虾线，淋上白酒、酱油腌制20分钟；剥去大蒜外层的脏皮，留下紧贴着蒜瓣的一层，用刀切去蒜头，用锡纸包好后刷上一层橄榄油，撒上适量盐、黑胡椒；将蒜头部分切成碎粒，放入油锅中煸炒至金黄出香味
     * food : 河虾,大蒜,黑胡椒,白酒,酱油,番茄酱,橄榄油
     * keywords : 黑胡椒 河虾 一层 大蒜 橄榄油
     * message : <h2>菜谱简介</h2><hr>     <h2>材料 </h2><hr>
     <p>河虾10只，大蒜2头，盐8克，黑胡椒8克，白酒15ml，酱油10ml，番茄酱10ml，橄榄油30ml</p>   <h2>做法 </h2><hr>
     <p>河虾洗净后剪去虾枪、虾须，在虾背上横着片一刀，深度约为虾肉的三分之二，不要切穿，然后取出虾线，淋上白酒、酱油腌制20分钟； </p>
     <p>剥去大蒜外层的脏皮，留下紧贴着蒜瓣的一层，用刀切去蒜头，用锡纸包好后刷上一层橄榄油，撒上适量盐、黑胡椒； </p>
     <p>将蒜头部分切成碎粒，放入油锅中煸炒至金黄出香味。烤盘底部刷上薄油，腌好的河虾沥去汁水，在背部放入炒香的蒜粒，撒上一层盐、黑胡椒； </p>
     <p>烤箱预热至180度，放入虾、大蒜，用上下火烘烤8-10分钟即可。</p>
     * name : 蒜香烤虾
     * img : http://api.avatardata.cn/Cook/Img?file=09720187c3384203aa340820cee89660.jpg
     * fcount : 0
     * rcount : 0
     * count : 804
     */

    private ResultEntity result;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public ResultEntity getResult() {
        return result;
    }

    public static class ResultEntity {
        private int id;
        private String description;
        private String food;
        private String keywords;
        private String message;
        private String name;
        private String img;
        private int fcount;
        private int rcount;
        private int count;

        public void setId(int id) {
            this.id = id;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setFood(String food) {
            this.food = food;
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

        public void setImg(String img) {
            this.img = img;
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

        public String getFood() {
            return food;
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

        public String getImg() {
            return img;
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
