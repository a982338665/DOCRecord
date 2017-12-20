package pers.lish.girl.enums;

/**
 * create by lishengbo on 2017-12-20 14:51
 * 枚举--管理异常
 * 一般不用写set方法，因为使用时尝试用构造方法创建
 *
 */
public enum ResultEnum {

    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    FAIL(0,"失败"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
