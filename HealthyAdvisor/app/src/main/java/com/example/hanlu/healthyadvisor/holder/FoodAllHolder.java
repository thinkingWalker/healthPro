package com.example.hanlu.healthyadvisor.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.FoodAllListInfo;
import com.example.hanlu.healthyadvisor.utils.UiUtils;

/**
 * Created by hanlu on 2016/3/10.
 */
public class FoodAllHolder extends BaseHolder<FoodAllListInfo.ResultEntity> {

    private ImageView imageView;
    private TextView name;
    private TextView keywords;

    @Override
    public View initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.holder_foodall_list, null);

        imageView = (ImageView) view.findViewById(R.id.item_food_all_image);
        name = (TextView) view.findViewById(R.id.item_food_all_name);
        return view;
    }

    @Override
    public void refreshView(FoodAllListInfo.ResultEntity data) {
        name.setText(data.getName());
        utils.display(imageView, data.getImg());
    }
}
