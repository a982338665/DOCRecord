package pers.lish.girl.domain;

/**
 * create by lishengbo on 2017-12-20 11:35
 * 接口返回结果封装
 */

public class ResultBean {
    /**
     * 错误编码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String  msg;
    /**
     * 具体内容
     */
    private Object  data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
