package com.example.hanlu.healthyadvisor.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

/**
 * Created by Admin on 2016/7/13  9:33
 *
 * @desc
 */
public class FabBehavior extends FloatingActionButton.Behavior {
    boolean visible=true;
    public FabBehavior(Context context,AttributeSet attrs) {
        super();
    }
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed >0 && visible){
            //向下滑动，hide
            hide(child);

        }else if (dyConsumed<0 &&!visible){
            //向上滑动   show
            show(child);
        }
    }

    private void show(FloatingActionButton fab) {
        fab.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        visible=true;
    }

    private void hide(FloatingActionButton fab) {
        visible=false;
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) fab.getLayoutParams();
        fab.animate().translationY(fab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }



}
