package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.RecipeSearchInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/9.
 */
public class RecipeSearchProtocol extends BaseProtocol<RecipeSearchInfo>{
    @Override
    protected RecipeSearchInfo parseJson(String json) {
        Gson gson=new Gson();
        RecipeSearchInfo recipeSearchInfo = gson.fromJson(json, RecipeSearchInfo.class);
        return recipeSearchInfo;
    }

    @Override
    protected String getKey() {
        return Constant.RECIPE_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.RECIPE_SEARCH_URL;
    }

}
