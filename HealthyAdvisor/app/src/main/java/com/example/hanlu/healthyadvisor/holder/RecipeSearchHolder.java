package com.example.hanlu.healthyadvisor.holder;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.RecipeSearchInfo;
import com.example.hanlu.healthyadvisor.utils.UiUtils;

/**
 * Created by hanlu on 2016/3/9.
 */
public class RecipeSearchHolder extends BaseHolder<RecipeSearchInfo.ResultEntity> {

    private TextView name;
    private TextView keyWords;
    private ImageView image;

    @Override
    public View initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.activity_recipe_search_content, null);
        name = (TextView) view.findViewById(R.id.recipe_search_result_name);
        keyWords = (TextView) view.findViewById(R.id.recipe_search_result_keywords);
        image = (ImageView) view.findViewById(R.id.recipe_search_result_image);
        return view;
    }

    @Override
    public void refreshView(RecipeSearchInfo.ResultEntity data) {
        name.setText(data.getName());
        keyWords.setText(data.getKeywords());
        utils.display(image, data.getImg());
    }


}
