package pers.li.support.session;

import pers.li.support.util.AESUtil;

/**
 * create by lishengbo on 2018-03-16 10:32
 * 记录session或者cookie的key值名称(加密和未加密的)
 */
public enum CookieSessionNameEnum {

    /**
     * 存储登录用户密码信息的cookie的key值
     */
    COOKIE_LOGIN_INFO("loginInfo", AESUtil.encrypt("loginInfo")+"."),
    /**
     * 存储用户信息的session的key值
     */
    SESSION_USER_INFO("userId","userName"),


    ;
    private String key;

    private String aESkey;

    CookieSessionNameEnum(String key, String aESkey) {
        this.key = key;
        this.aESkey = aESkey;
    }

    public String getKey() {
        return key;
    }

    public String getaESkey() {
        return aESkey;
    }

}
