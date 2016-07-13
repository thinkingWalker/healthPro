package com.example.hanlu.healthyadvisor.protocol;

import com.example.hanlu.healthyadvisor.bean.MedicineHouseInfo;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.google.gson.Gson;

/**
 * Created by hanlu on 2016/3/8.
 */
public class MedicineHouseProtocol extends BaseProtocol<MedicineHouseInfo> {
    @Override
    protected MedicineHouseInfo parseJson(String json) {
        Gson gson = new Gson();
        MedicineHouseInfo medicineHouseInfo = gson.fromJson(json, MedicineHouseInfo.class);
        return medicineHouseInfo;
    }

    @Override
    protected String getKey() {
        return Constant.MEDICINE_HOUSE_KEY;
    }

    @Override
    protected String getUrl() {
        return Constant.MEDICINE_HOUSE_AROUND_URL;
    }
}
