package com.example.hanlu.healthyadvisor.holder;

import android.view.View;

import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.lidroid.xutils.BitmapUtils;

/**
 * Created by hanlu on 2016/3/6.
 */
public abstract class BaseHolder<T> {
    public BitmapUtils utils=new BitmapUtils(UiUtils.getContext());
    private View contentView;

    public View getContentView() {
        return contentView;
    }

    public BaseHolder() {
        contentView = initView();
        contentView.setTag(this);
    }

    public  abstract View initView();


    public  void setData(T data) {
        refreshView(data);
    }

    public  abstract void refreshView(T data);

}
