package com.example.hanlu.healthyadvisor.holder;

import android.view.View;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.utils.UiUtils;

/**
 * Created by hanlu on 2016/3/6.
 */
public class MoreHolder extends BaseHolder<Integer> {

    public static final int HAS_MORE = 0;
    public static final int HAS_NO_MORE = 1;
    public static final int HAS_MORE_EMPTY = 2;
    public static final int HAS_MORE_ERROR = 3;

    private TextView more;
    private TextView noMore;
    private TextView error;

    @Override
    public View initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.question_load_more, null);
        more = (TextView) view.findViewById(R.id.question_load_more);
        noMore = (TextView) view.findViewById(R.id.question_has_no_more);
        error = (TextView) view.findViewById(R.id.question_has_more_error);
        return view;
    }

    @Override
    public void refreshView(Integer data) {
        more.setVisibility(data == HAS_MORE ? View.VISIBLE : View.GONE);
        noMore.setVisibility(data == HAS_NO_MORE ? View.VISIBLE : View.GONE);
        if (data == HAS_MORE_EMPTY) {
            more.setVisibility(View.GONE);
            noMore.setVisibility(View.GONE);
        }

        if (data==HAS_MORE_ERROR){
            more.setVisibility(View.GONE);
            noMore.setVisibility(View.GONE);
            error.setVisibility(View.VISIBLE);
        }
    }
}
