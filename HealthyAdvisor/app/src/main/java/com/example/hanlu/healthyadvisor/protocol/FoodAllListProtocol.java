package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.FoodAllListInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/10.
 */
public class FoodAllListProtocol extends BaseProtocol<FoodAllListInfo>{
    @Override
    protected FoodAllListInfo parseJson(String json) {
        Gson gson=new Gson();
        FoodAllListInfo foodAllListInfo = gson.fromJson(json, FoodAllListInfo.class);
        return foodAllListInfo;
    }

    @Override
    protected String getKey() {
        return Constant.FOOD_ALL_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.FOOD_ALL_LIST_URL;
    }
}
