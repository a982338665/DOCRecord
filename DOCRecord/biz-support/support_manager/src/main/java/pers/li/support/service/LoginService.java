package pers.li.support.service;

import pers.li.support.common.ResultBean;
import pers.li.support.entity.UserBean;

import java.util.Map; /**
 * create by lishengbo on 2018-03-12 14:21
 */
public interface LoginService {


    ResultBean<UserBean> login(Map map) /*throws Exception*/;
}
