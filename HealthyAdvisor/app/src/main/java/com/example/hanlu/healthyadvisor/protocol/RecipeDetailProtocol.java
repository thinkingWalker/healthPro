package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.RecipeDetailInfo;
import com.example.hanlu.healthyadvisor.bean.RecipeInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/9.
 */
public class RecipeDetailProtocol extends BaseProtocol<RecipeDetailInfo> {
    @Override
    protected RecipeDetailInfo parseJson(String json) {
        Gson gson=new Gson();
        RecipeDetailInfo recipeInfo = gson.fromJson(json, RecipeDetailInfo.class);
        return recipeInfo;
    }

    @Override
    protected String getKey() {
        return Constant.RECIPE_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.RECIPE_DETAIL_URL;
    }
}
