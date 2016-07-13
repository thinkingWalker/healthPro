package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.RecipeInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/6.
 */
public class NutritionRecipeProtocol extends BaseProtocol<RecipeInfo> {
    @Override
    protected RecipeInfo parseJson(String json) {
        Gson gson = new Gson();
        RecipeInfo recipeInfo = gson.fromJson(json, RecipeInfo.class);
        return recipeInfo;
    }

    @Override
    protected String getKey() {
        return Constant.RECIPE_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.RECIPE_LIST_URL;
    }
}
