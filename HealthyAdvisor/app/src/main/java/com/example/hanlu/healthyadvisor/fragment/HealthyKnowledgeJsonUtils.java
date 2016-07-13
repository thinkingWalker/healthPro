package com.example.hanlu.healthyadvisor.fragment;

import com.example.hanlu.healthyadvisor.bean.HealthInfo;
import com.example.hanlu.healthyadvisor.bean.HealthyListInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

/**
 * Created by hanlu on 2016/6/29.
 * 健康知识的json格式化类
 */
public class HealthyKnowledgeJsonUtils {
    public static HealthyListInfo formatJson(byte[] is) throws JSONException {
        String json = new String(is);
        HealthyListInfo healthyListInfo = new HealthyListInfo();
        List<HealthInfo> healthInfoList = healthyListInfo.getHealthyList();

        JSONObject jsonObject = new JSONObject(json);
        JSONArray result = jsonObject.getJSONArray("result");
        for (int i = 0; i < result.length(); i++) {
            HealthInfo healthInfo = new HealthInfo();
            JSONObject resultJSONObject = result.getJSONObject(i);
            healthInfo.id = resultJSONObject.getInt("id");
            healthInfo.title = resultJSONObject.getString("title");
            healthInfo.description = resultJSONObject.getString("description");
            healthInfo.img = resultJSONObject.getString("img");
            healthInfo.keywords = resultJSONObject.getString("keywords");
            healthInfo.loreclass = resultJSONObject.getInt("loreclass");
            healthInfo.time = resultJSONObject.getInt("time");
            healthInfo.fcount = resultJSONObject.getInt("fcount");
            healthInfo.count = resultJSONObject.getInt("count");
            healthInfoList.add(healthInfo);

        }

        return healthyListInfo;
    }
}
