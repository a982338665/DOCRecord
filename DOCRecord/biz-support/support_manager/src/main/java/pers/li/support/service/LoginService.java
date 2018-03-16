package pers.li.support.service;

import pers.li.support.common.ResultBean;
import pers.li.support.entity.UserBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * create by lishengbo on 2018-03-12 14:21
 */
public interface LoginService {


    ResultBean<UserBean> login(Map map) /*throws Exception*/;

    /**
     * 获取用户菜单信息
     * @return
     */
    List<Map<String,String>> getMenu();

//    public void insert(UserBeanTest s);
}
