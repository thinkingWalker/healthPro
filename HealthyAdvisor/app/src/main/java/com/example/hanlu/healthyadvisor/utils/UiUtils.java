package com.example.hanlu.healthyadvisor.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;

import com.example.hanlu.healthyadvisor.MyApplication;

/**
 * Created by hanlu on 2016/3/5.
 */
public class UiUtils {
    public static Context getContext() {
        return MyApplication.getContext();
    }

    /**
     * dip 转 px
     *
     * @param dip
     * @return
     */
    public static int dip2px(int dip) {
        //
        // 公式： dp = px / (dpi / 160) px = dp * (dpi / 160)
        // dp = px / denisity
        // px = dp * denisity;
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        float density = metrics.density;
        return (int) (dip * density + 0.5f);
    }

    public static int px2dip(int px) {
        // dp = px / denisity
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        float density = metrics.density;
        return (int) (px / density + 0.5f);
    }

    public static Activity getActivity() {
        return MyApplication.getActivity();
    }

    public static void runOnUiThread(Runnable runnable) {
        //如果是主线程则直接运行，如果是子线程则post运行
        if (android.os.Process.myTid() == MyApplication.gettId()) {
            runnable.run();
        } else {
            MyApplication.getHandler().post(runnable);
        }

    }


    public static String getLastLocateCity() {
        SharedPreferences city = getContext().getSharedPreferences("city", Context.MODE_PRIVATE);
        String city_name = city.getString("city_name", null);
        return city_name;
    }

    public static void setLastLocateCity(String name) {
        getContext().getSharedPreferences("city", Context.MODE_PRIVATE).edit().putString("city_name", name).commit();

    }


    public static void setLastLocateLatitude(double latitude) {
        getContext().getSharedPreferences("latitude", Context.MODE_PRIVATE).edit().putFloat("number", (float) latitude).commit();
    }

    public static float getLastLocateLatitude() {
        float aFloat = getContext().getSharedPreferences("latitude", Context.MODE_PRIVATE).getFloat("number", 0);
        return aFloat;
    }

    public static float getLastLocatelongtitude() {
        float aFloat = getContext().getSharedPreferences("longtitude", Context.MODE_PRIVATE).getFloat("number", 0);
        return aFloat;
    }

    public static void setLastLocateLongitude(double longitude) {
        getContext().getSharedPreferences("longtitude", Context.MODE_PRIVATE).edit().putFloat("number", (float) longitude).commit();

    }

    public static void setFragmentItemClicked(boolean isClick,int position) {
        getContext().getSharedPreferences("item_status", Context.MODE_PRIVATE).edit().putBoolean("clicked",isClick);
    }
}
