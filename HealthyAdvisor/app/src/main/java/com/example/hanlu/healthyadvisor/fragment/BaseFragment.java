package com.example.hanlu.healthyadvisor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by hanlu on 2016/3/5.
 */
public abstract class BaseFragment extends Fragment {
    private ListView listView;
    public View mRootView;
    public BitmapUtils utils;
    private LoadingView loadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        loadingView = new LoadingView(UiUtils.getContext()) {
            @Override
            protected LoadResult loadData() {
                return BaseFragment.this.loadData();
            }

            @Override
            protected View createSuccessView() {
                return BaseFragment.this.createSuccessView();
            }
        };
        loadingView.loadPage();
        return loadingView;
    }


    public <T> LoadingView.LoadResult checkData(List<T> data) {
        if (data.size() == 0) {
            return LoadingView.LoadResult.ERROR;
        } else {
            return LoadingView.LoadResult.SUCCESS;
        }
    }

    protected abstract View createSuccessView();

    protected abstract LoadingView.LoadResult loadData();



}
