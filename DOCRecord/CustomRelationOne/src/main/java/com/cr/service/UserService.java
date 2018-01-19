package com.cr.service;

import com.cr.entity.LoginUserBean;

import java.util.Map; /**
 * 业务接口;站在使用者角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型(return 类型/异常 )
 * create by lishengbo on 2018-01-02 10:12
 */
public interface UserService {
    /**
     * 登录
     * @param map
     * @return
     */
    LoginUserBean login(Map<String, String> map);
}
