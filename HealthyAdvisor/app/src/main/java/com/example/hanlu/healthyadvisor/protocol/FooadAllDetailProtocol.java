package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.FoodAllDetailInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/10.
 */
public class FooadAllDetailProtocol extends BaseProtocol<FoodAllDetailInfo> {


    @Override
    protected FoodAllDetailInfo parseJson(String json) {
        Gson gson=new Gson();
        FoodAllDetailInfo foodAllDetailInfo = gson.fromJson(json, FoodAllDetailInfo.class);

        return foodAllDetailInfo;
    }

    @Override
    protected String getKey() {
        return Constant.FOOD_ALL_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.FOOD_ALL_DETAIL_URL;
    }
}
