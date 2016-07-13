package com.example.hanlu.healthyadvisor.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.RecipeInfo;
import com.example.hanlu.healthyadvisor.holder.MoreHolder;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by hanlu on 2016/3/6.
 */

public abstract class NutritionRecylerAdapter extends RecyclerView.Adapter<NutritionRecylerAdapter.MasonryView> {
    private static final int LOAD_MODE_TYPE = 1;
    private static final String TAG = "result";
    private List<RecipeInfo.ResultEntity> data;
    private BitmapUtils utils;


    public NutritionRecylerAdapter(List<RecipeInfo.ResultEntity> data) {
        this.data = data;
        utils = new BitmapUtils(UiUtils.getContext());
    }


    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyler_item, viewGroup, false);
            return new MasonryView(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return LOAD_MODE_TYPE;
        } else {
            return super.getItemViewType(position);
        }
    }


    public static final int HAS_MORE = 0;
    public static final int HAS_NO_MORE = 1;
    public static final int HAS_MORE_EMPTY = 2;
    int state = 0;

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void onBindViewHolder(final MasonryView holder, int position) {
        Log.i(TAG, "onBindViewHolder: " + getItemViewType(position) + "  " + position + "  " + state);
        if (getItemViewType(position) == LOAD_MODE_TYPE) {
            View view = View.inflate(UiUtils.getContext(), R.layout.question_load_more, null);
            TextView more = (TextView) view.findViewById(R.id.question_load_more);
            TextView noMore = (TextView) view.findViewById(R.id.question_has_no_more);
            loadMoreData();
            more.setVisibility(View.VISIBLE);
            noMore.setVisibility(state == HAS_NO_MORE ? View.VISIBLE : View.GONE);
            if (state == HAS_MORE_EMPTY) {
                more.setVisibility(View.GONE);
                noMore.setVisibility(View.GONE);
            }
        } else {
            utils.display(holder.imageView, data.get(position).getImg());
            holder.textView.setText(data.get(position).getName());
        }
        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });


        }

    }


    private void loadMoreData() {
        new Thread() {
            int state = MoreHolder.HAS_MORE;

            @Override
            public void run() {
                final List<RecipeInfo.ResultEntity> moreDatas = LoadMore();
                if (moreDatas.size() == 0) {
                    state = MoreHolder.HAS_NO_MORE;
                } else if (moreDatas.size() < Constant.ROW_COUNTS) {
                    state = MoreHolder.HAS_NO_MORE;
                } else {
                    state = MoreHolder.HAS_MORE;
                    UiUtils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setState(state);
                            data.addAll(moreDatas);
                            notifyDataSetChanged();

                        }
                    });
                }
            }
        }.start();
    }

    public abstract List<RecipeInfo.ResultEntity> LoadMore();

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MasonryView extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.masonry_item_img);
            textView = (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

    }

}

