package com.example.hanlu.healthyadvisor.bean;

import java.util.List;

/**
 * Created by hanlu on 2016/3/10.
 */
public class MedicineQueryInfo {

    /**
     * id : 2
     * count : 962
     * rcount : 0
     * fcount : 0
     * img : http://api.avatardata.cn/Drug/Img?file=c077248728f04552983f618bc9d7f3da.jpg
     * keywords : 相关 本品 乙酰 氨基 镇痛药
     * message : <p>【批准文号】</p>
     <p>国药准字H41025246</p>
     <p>【药品类型】</p>
     <p>解热镇痛</p>
     <p>【中文名】</p>
     <p>康诺药业 氨酚巴妥片</p>
     <p>【产品英文名】</p>
     <p>Paracetamol and Phenobarbital Tablets</p>
     <p>【生产企业】</p>
     <p>开封康诺药业有限公司</p>
     <p>【适应症】</p>
     <p>本品为解热镇痛药。用于控制发热、头痛、关节痛、周身疼痛、牙痛等症状。</p>
     <p>【药品性状】</p>
     <p>本品为白色片。</p>
     <p>【药品禁忌】</p>
     <p>乙醇中毒者慎用。本品为症状控制药，用药期间不应超过5天。长期使用可导致肾功能损害。勿与含有同量成分的其它药物合用。对本品成分过敏者禁用。肝肾功能不全者、支气管哮喘者、呼吸抑制及卟啉病患者禁用。对乙酰氨基酚和苯巴比妥均可通过胎盘，孕妇应用后可能对胎儿造成不良影响。本品可通过乳汁分泌，故不推荐哺乳期妇女使用。3岁以下儿童因肝肾功能等发育不全，在有效药物浓度范围内也可影响儿童认知功能，故应避免使用。</p>
     <p>【药理作用】</p>
     <p>本品为解热镇痛药。对乙酰氨基酚为解热镇痛剂，其作用机制是通过抑制中枢神经系统中前列腺素的合成及阻断痛觉神经末梢的冲动而产生镇痛作用，并通过体温调节中枢产生解热作用；苯巴比妥具有镇静、催眠、抗惊厥作用，与对乙酰氨基酚合用可加强镇静作用。</p>
     <p>【药物相互作用】</p>
     <p>暂无相关信息。</p>
     <p>【不良反应】</p>
     <p>对乙酰氨基酚较少引起不良反应，但少数病例，如有药物过敏史者会引起过敏性皮炎、剥脱性皮炎、血管神经性水肿，出现上述过敏现象时，立即停药，严重时可去医院治疗。</p>
     <p>【产品规格】</p>
     <p>对乙酰氨基酚0.25g，苯巴比妥10mg</p>
     <p>【包装规格】</p>
     <p></p>
     <p>【药品成分】</p>
     <p>本品为复方制剂，其主要成分为对乙酰氨基酚，苯巴比妥。</p>
     <p>【孕妇用药】</p>
     <p>暂无相关信息。</p>
     <p>【儿童用药】</p>
     <p>暂无相关信息。</p>
     <p>【老年患者用药】</p>
     <p>暂无相关信息。</p>
     <p>【用法用量】</p>
     <p>口服。一次1～2片，一日3次，或遵医嘱。</p>
     <p>【贮藏方法】</p>
     <p>密封保存。</p>
     <p>【注意事项】</p>
     <p>暂无相关信息。</p>
     <p>— 该说明书仅作参考</p>
     * name : 氨酚巴妥片
     * price : 444
     * tag : 哮喘,解热镇痛,过敏,牙痛
     * type : 化学药品
     * codes : [{"id":16,"drug":2,"code":"6920389200065","factory":"长春益肾康生物制药有限公司"}]
     * numbers : [{"id":10,"drug":2,"number":"H41025246","factory":"开封康诺药业有限公司"},{"id":9,"drug":2,"number":"H22025678","factory":"长春益肾康生物制药有限公司"}]
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
        private int count;
        private int rcount;
        private int fcount;
        private String img;
        private String keywords;
        private String message;
        private String name;
        private int price;
        private String tag;
        private String type;
        private String factory;

        public String getFactory() {
            return factory;
        }

        /**
         * id : 16
         * drug : 2
         * code : 6920389200065
         * factory : 长春益肾康生物制药有限公司
         */

        private List<CodesEntity> codes;
        /**
         * id : 10
         * drug : 2
         * number : H41025246
         * factory : 开封康诺药业有限公司
         */

        private List<NumbersEntity> numbers;

        public void setId(int id) {
            this.id = id;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
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

        public void setPrice(int price) {
            this.price = price;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setCodes(List<CodesEntity> codes) {
            this.codes = codes;
        }

        public void setNumbers(List<NumbersEntity> numbers) {
            this.numbers = numbers;
        }

        public int getId() {
            return id;
        }

        public int getCount() {
            return count;
        }

        public int getRcount() {
            return rcount;
        }

        public int getFcount() {
            return fcount;
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

        public int getPrice() {
            return price;
        }

        public String getTag() {
            return tag;
        }

        public String getType() {
            return type;
        }

        public List<CodesEntity> getCodes() {
            return codes;
        }

        public List<NumbersEntity> getNumbers() {
            return numbers;
        }

        public static class CodesEntity {
            private int id;
            private int drug;
            private String code;
            private String factory;

            public void setId(int id) {
                this.id = id;
            }

            public void setDrug(int drug) {
                this.drug = drug;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public void setFactory(String factory) {
                this.factory = factory;
            }

            public int getId() {
                return id;
            }

            public int getDrug() {
                return drug;
            }

            public String getCode() {
                return code;
            }

            public String getFactory() {
                return factory;
            }
        }

        public static class NumbersEntity {
            private int id;
            private int drug;
            private String number;
            private String factory;

            public void setId(int id) {
                this.id = id;
            }

            public void setDrug(int drug) {
                this.drug = drug;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public void setFactory(String factory) {
                this.factory = factory;
            }

            public int getId() {
                return id;
            }

            public int getDrug() {
                return drug;
            }

            public String getNumber() {
                return number;
            }

            public String getFactory() {
                return factory;
            }
        }
    }
}
