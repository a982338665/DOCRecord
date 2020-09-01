package pers.li.support.enums;

/**
 * create by lishengbo on 2017-12-20 14:51
 * 枚举--管理异常
 *
 *
 */
public enum ResultEnum {

    /**
     * 登录查询异常
     */
    LOGIN_ERROR(-1,"登录查询异常"),
    USER_NOTEXIST(100,"用户不存在"),
    USER_PWDERROR(101,"用户密码不正确"),
    USER_PWDNULL(102,"登录密码不能为空"),
    USER_RESUBMIT(103,"请不要重复提交"),
    USER_VERCodeERROR(104,"验证码输入错误"),
    USER_COOKIEERROR(105,"验证cookie无效"),


    ;
    private Integer code;

    private String data;

    ResultEnum(Integer code, String data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return data;
    }
}
