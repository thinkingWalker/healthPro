package com.example.hanlu.healthyadvisor.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/6/29  10:49
 *
 * @desc
 */
public class HealthyListInfo  extends Entity implements  ListEntity<HealthInfo>{


    @Override
    public String toString() {
        return "HealthyListInfo{" +
                "healthyList=" + healthyList +
                '}';
    }

    private List<HealthInfo> healthyList=new ArrayList<HealthInfo>();

    @Override
    public List<HealthInfo> getList() {
        return healthyList;
    }

    public List<HealthInfo> getHealthyList() {
        return healthyList;
    }

    public void setHealthyList(List<HealthInfo> healthyList) {

        this.healthyList = healthyList;
    }


}
