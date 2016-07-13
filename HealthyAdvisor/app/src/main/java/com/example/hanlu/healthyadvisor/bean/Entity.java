package com.example.hanlu.healthyadvisor.bean;

import java.io.Serializable;

/**
 * Created by Admin on 2016/6/29  14:15
 *bean的基类，都需要有一个id
 * @desc
 */
public class    Entity implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
