package com.example.hanlu.healthyadvisor.bean;

/**
 * Created by Admin on 2016/6/29  11:09
 *解析健康知识的头部bean
 * @desc
 */
public class EntityHead{
    private int total;
    private int error_code;
    private String reason;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
