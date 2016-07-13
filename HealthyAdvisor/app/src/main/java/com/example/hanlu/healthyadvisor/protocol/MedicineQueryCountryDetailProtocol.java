package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.MedicineQueryInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/10.
 */
public class MedicineQueryCountryDetailProtocol extends BaseProtocol<MedicineQueryInfo> {
    @Override
    protected MedicineQueryInfo parseJson(String json) {
        Gson gson = new Gson();
        MedicineQueryInfo medicineQueryInfo = gson.fromJson(json, MedicineQueryInfo.class);
        return medicineQueryInfo;
    }

    @Override
    protected String getKey() {
        return Constant.MEDICINE_QUERY_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.MEDICINE_QUERY_NUMBER_URL;
    }
}
