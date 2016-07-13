package com.example.hanlu.healthyadvisor.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.utils.UiUtils;


/**
 * Created by hanlu on 2016/2/20.
 */
public abstract class LoadingView extends FrameLayout {
    public static final int LOADIING_STATE = 0;
    public static final int ERROR_STATE = 1;
    public static final int SUCCESS_STATE = 2;
    public static final int EMPTY_STATE = 3;
    public int state;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 从服务器获得数据后加载界面
     */
    public void loadPage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final LoadResult result = loadData();
                UiUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        state = result.values;
                        showPage();
                    }
                });
            }
        }).start();
        showPage();
    }

    protected abstract LoadResult loadData();

    public enum LoadResult {
        ERROR(1), SUCCESS(2), EMPTY(3);
        public int values;

        LoadResult(int values) {
            this.values = values;
        }

        public int getValues() {
            return values;
        }
    }


    public void showPage() {
        if (loadingView != null) {
            loadingView.setVisibility(state == LOADIING_STATE ? View.VISIBLE : View.INVISIBLE);
        }
        if (errorView != null) {
            errorView.setVisibility(state == ERROR_STATE ? View.VISIBLE : View.INVISIBLE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(state == EMPTY_STATE ? View.VISIBLE : View.INVISIBLE);
        }
        if (successView == null && state == SUCCESS_STATE) {
            successView = createSuccessView();
        }
        if (successView != null) {
            addView(successView);
        }
    }

    protected abstract View createSuccessView();

    View loadingView;
    View errorView;
    View successView;
    View emptyView;

    /**
     * 初始化view
     */
    protected void init() {
        loadingView = createLoadingView();
        if (loadingView != null) {
            addView(loadingView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }

        errorView = createErrorView();
        if (errorView != null) {
            addView(errorView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        emptyView = createEmptyView();
        if (emptyView != null) {
            addView(emptyView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    private View createEmptyView() {
        View view=View.inflate(UiUtils.getContext(),R.layout.view_empty,null);

        return view;
    }

    private View createErrorView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.view_error, null);
        return view;
    }

    private View createLoadingView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.view_loading, null);
        return view;
    }
}
