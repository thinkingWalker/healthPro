package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by hanlu on 2016/3/9.
 */
public class RecipeSearchInfo {

    /**
     * id : 111160
     * food : 高粉,全麦粉,酵母粉,核桃
     * description : 小诀窍1、夏天天气热，用面包机揉面，面包机很容易出现高温而不工作了，这时可以选择把盖子打开散热，并且将一些液体材料事先在冰箱里降温；2、此面团无只要揉到面团光滑就可以了，不用计较有没有出很薄的膜
     * name : 无油低糖全麦核桃包
     * img : http://api.avatardata.cn/Cook/Img?file=16df1759fbaf4ac186a0fa0a1a22a559.jpg
     * keywords : 面团 核桃 面包机 面包 发酵
     * message : <h2>菜谱简介</h2><hr>   天还未亮就起了，阳台的地上散落着几片枯叶和几朵白色的茉莉花瓣，看样子昨晚有风刮过，我却全然不知。 此刻的世界还在安睡。偶尔传来几声鸟的鸣叫。远处的路灯还开着，散着淡淡的黄色的光。 天色就在这一会儿慢慢变亮了，近处的工地可以看见零星的工人去上工了。 把阳台上的残花败叶打扫干净，给每一盆花都喂饱了水，我的一天也开始了。 一直不喜欢用太甜的面包做早餐，觉得过于油腻，甜包更适合做下午茶点。所以如果是自己吃的话一般会选择做比较淡味的面包。 昨天做了一款全麦核桃面包，无油低糖的，这种面包味道比较清淡，只有淡淡的麦香和核桃香，更适合做早餐，搭配着蔬菜、培根和早餐芝士一起吃，不会夺了其它食材的味道。 昨天接近中午时分才开始用面包机合面，合好以后就丢进冰箱里面了。因为现在天气太热，发酵会很快，而我又想睡个午觉，把面团放入冰箱冷藏室降低酵母的活性低温发酵，这样睡好午觉，面团也就发好了。下午把面团取出来回到室温，继续下面的操作就可以了。做面包从揉面开始到最后出炉总是需要很长时间的，所以可以自己找好节点分配时间，化整为零来做，这样就不会耽误做其它事情了。   <h2>材料 </h2><hr>
     <p>高粉280克，全麦粉20克，白糖15克，盐4克，安琪酵母粉6克，水200克，核桃90克。</p>   <h2>做法 </h2><hr>
     <p>1、将生桃仁放入烤箱中层，150度烤10分钟。冷却后。将核桃掰成稍小的颗粒。 </p>
     <p>2、将高粉、全麦粉、白糖、盐、水、酵母揉成团，加入核桃碎继续揉，至表面光滑的面团。（这一步我是用面包机揉面，总共揉了三个二十分钟，在最后十分钟加入核桃碎）。 </p>
     <p>3、基本发酵至两倍大。 </p>
     <p>4、滚圆，松驰15分钟。 </p>
     <p>5、将面团擀成长椭圆形，翻面，卷成圆柱状，接缝捏紧，摆入烤盘。 </p>
     <p>6、视情况加盖保鲜膜，温暖处发酵至两倍大，均匀撒上全麦粉，再用刀割几个口。 </p>
     <p>7、烤箱预热，中层，上下管，180度30分钟。</p>   <h2>小诀窍</h2><hr>
     <p>1、夏天天气热，用面包机揉面，面包机很容易出现高温而不工作了，这时可以选择把盖子打开散热，并且将一些液体材料事先在冰箱里降温； </p>
     <p>2、此面团无只要揉到面团光滑就可以了，不用计较有没有出很薄的膜。</p>
     * fcount : 0
     * rcount : 0
     * count : 72
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
        private String food;
        private String description;
        private String name;
        private String img;
        private String keywords;
        private String message;
        private int fcount;
        private int rcount;
        private int count;

        public void setId(int id) {
            this.id = id;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getFood() {
            return food;
        }

        public String getDescription() {
            return description;
        }

        public String getName() {
            return name;
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
