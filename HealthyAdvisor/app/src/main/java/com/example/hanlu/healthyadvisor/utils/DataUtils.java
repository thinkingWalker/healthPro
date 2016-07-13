package com.example.hanlu.healthyadvisor.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Admin on 2016/6/22  17:21
 *
 * @desc
 */
public class DataUtils {
    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private static String LAST_REFRESH_TIME = "last_refresh_time.pref";

    /**
     * 记录列表上次刷新时间
     *
     * @param key
     * @param value
     * @return void
     * @author 火蚁
     * 2015-2-9 下午2:21:37
     */
    public static void putToLastRefreshTime(Context context,String key, String value) {
        SharedPreferences preferences = getPreferences(context,LAST_REFRESH_TIME);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static SharedPreferences getPreferences(Context context,String prefName) {
        return context.getSharedPreferences(prefName,
                Context.MODE_MULTI_PROCESS);
    }

    public static String getCurTimeStr() {
        Calendar cal = Calendar.getInstance();
        String curDate = dateFormater.get().format(cal.getTime());
        return curDate;
    }
}
