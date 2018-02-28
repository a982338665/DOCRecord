package com.example.ajaxkuayu;

/**
 * create by lishengbo on 2018-02-27 14:17
 */
public class ResultBean {

    /**
     * 自动生成get/set
     * 1.鼠标移至data前面
     * 2.alt+enter
     * 3.按提示选择
     */
    private  String data;



    public ResultBean(String data) {
         this.data=data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
