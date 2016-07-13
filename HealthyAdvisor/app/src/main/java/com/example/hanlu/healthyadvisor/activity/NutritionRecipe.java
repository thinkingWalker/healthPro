package com.example.hanlu.healthyadvisor.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;


import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.adapter.NutritionRecylerAdapter;
import com.example.hanlu.healthyadvisor.bean.RecipeInfo;
import com.example.hanlu.healthyadvisor.protocol.NutritionRecipeProtocol;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.umeng.analytics.MobclickAgent;

import java.util.List;

/**
 * Created by hanlu on 2016/3/5.
 */
public class NutritionRecipe extends DefaultActivity implements NutritionRecylerAdapter.OnItemClickLitener {
    private static final String TAG = "tag";
    private RecyclerView recyclerView;
    private List<RecipeInfo.ResultEntity> data;
    private SwipeRefreshLayout mSwipeLayout;
    int page = 1;
    @Override
    public void initView() {
        LoadingView loadingView = new LoadingView(this) {
            @Override
            protected LoadResult loadData() {
                NutritionRecipeProtocol protocol = new NutritionRecipeProtocol();
                RecipeInfo load = protocol.load(1, 0, 0, 0, null, null, null);
                data = load.getResult();
                return checkData(data);
            }
            @Override
            protected View createSuccessView() {
                View view = View.inflate(UiUtils.getContext(), R.layout.activity_nutrition, null);


                recyclerView = (RecyclerView) view.findViewById(R.id.recyler);
                NutritionRecylerAdapter adapter = new NutritionRecylerAdapter(data) {
                    @Override
                    public List<RecipeInfo.ResultEntity> LoadMore() {
                        page++;
                        NutritionRecipeProtocol protocol = new NutritionRecipeProtocol();
                        RecipeInfo load = protocol.load(page, 0, 0, 0, null, null, null);
                        List<RecipeInfo.ResultEntity> result = load.getResult();
                        return result;
                    }
                };
                recyclerView.setAdapter(adapter);

                //设置layoutManager
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                //设置adapter

                //设置item之间的间隔
                SpacesItemDecoration decoration = new SpacesItemDecoration(16);
                recyclerView.addItemDecoration(decoration);
                adapter.setOnItemClickLitener(NutritionRecipe.this);
                return view;
            }
        };
        default_title.setText("营养配餐");
        default_content.addView(loadingView);
        loadingView.loadPage();
    }

    /**
     * 设置添加屏幕的背景透明度的方法
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    @Override
    public void initData() {
    }


    //瀑布流的点击事件
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(UiUtils.getContext(), RecipeDetailActivity.class);
        intent.putExtra("id", data.get(position).getId());
        startActivity(intent);
    }


    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
