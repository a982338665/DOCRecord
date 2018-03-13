package pers.li.support.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.li.support.common.DefineCode;
import pers.li.support.common.DefineMould;
import pers.li.support.common.ResultBean;
import pers.li.support.dao.UserBeanDAO;
import pers.li.support.entity.UserBean;
import pers.li.support.enums.ResultEnum;
import pers.li.support.exception.ThrowException;
import pers.li.support.service.LoginService;
import pers.li.support.util.MD5Util;

import java.util.Map;

/**
 * create by lishengbo on 2018-03-12 14:21
 */
@Service
public class LoginServiceImpl implements LoginService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserBeanDAO userBeanDAO;

    public ResultBean<UserBean> login(Map map) /*throws Exception*/ {
        String msg = DefineMould.login_service + "THREADID = " + Thread.currentThread().getId() + ".|登录|login|" + map;
        logger.debug(msg);
        UserBean userBean;
        //密码进行MD5加密
        if (null != map.get("loginPass") && !("").equals(map.get("loginPass"))) {
            map.put("loginPass", MD5Util.MD5(map.get("loginPass").toString()));
        } else {
            //提示登录密码不能为空
            throw new ThrowException(ResultEnum.USER_PWDNULL);
        }
        try {
            userBean = userBeanDAO.selectByLoginName(map.get("loginName").toString());
        } catch (Exception e) {
//            e.printStackTrace();
            throw new ThrowException(ResultEnum.LOGIN_ERROR);
        }
        //用来测试全局异常返回
        //int s=1/0;
        //若没有查询到登录用户，则返回提示信息---------------------
        if (userBean == null) {
            throw new ThrowException(ResultEnum.USER_NOTEXIST);
            //若存在该用户----------------------------
        } else {
            //校验密码
            if (map.get("loginPass").equals(userBean.getLoginPass())) {
                return new ResultBean<UserBean>(DefineCode.CODE_SUCCESS, userBean);
            } else {
                throw new ThrowException(ResultEnum.USER_PWDERROR);
            }

        }


    }
}
