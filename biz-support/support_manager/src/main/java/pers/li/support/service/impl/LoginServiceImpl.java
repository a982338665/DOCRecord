package pers.li.support.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.li.support.common.DefineCode;
import pers.li.support.common.DefineMould;
import pers.li.support.common.ResultBean;
import pers.li.support.dao.MenuBeanDAO;
import pers.li.support.dao.UserBeanDAO;
import pers.li.support.entity.UserBean;
import pers.li.support.enums.ResultEnum;
import pers.li.support.exception.ThrowException;
import pers.li.support.service.LoginService;
import pers.li.support.session.CookieSessionNameEnum;
import pers.li.support.session.DealCookieUtil;
import pers.li.support.session.DealSessionUtil;
import pers.li.support.util.MD5Util;
import pers.li.support.util.rule.UserInfoDealUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * create by lishengbo on 2018-03-12 14:21
 */
@Service
public class LoginServiceImpl implements LoginService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserBeanDAO userBeanDAO;

    @Autowired
    private MenuBeanDAO menuBeanDAO;

    public ResultBean<UserBean> login(Map map/*,HttpServletRequest request*/) /*throws Exception*/ {
        String msg = DefineMould.login_service + "THREADID = " + Thread.currentThread().getId() + ".|登录|login|" + map;
        logger.debug(msg);
        UserBean userBean;

        //获取用户密码
        String userPass = map.get("userPass").toString();
        //获取用户名
        String userName = map.get("userName").toString();
        //获取是否记住密码
        String isRemember="";
        if(map.get("remember_me")!=null){
            isRemember = map.get("remember_me").toString();
        }
        //密码进行MD5加密-===========================
        if (null != userPass && !("").equals(userPass)) {
            map.put("userPass", MD5Util.MD5(userPass));
        } else {
            //提示登录密码不能为空
            throw new ThrowException(ResultEnum.USER_PWDNULL);
        }

        //验证码检测=================================
        String verifyCode="";
        if(map.get("verifyCode")!=null){
            verifyCode=map.get("verifyCode").toString();
        }
//        verifyCode(verifyCode);


        try {
            userBean = userBeanDAO.selectByLoginName(userName);
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
            //校验密码成功
            if (MD5Util.MD5(userPass).equals(userBean.getLoginPass())) {
                //需要记住密码时，存cookie
                if("1".equals(isRemember)){
                    String loginInfo = UserInfoDealUtil.getUserCookie(userName,userPass);
                    DealCookieUtil.addAESCookie(CookieSessionNameEnum.COOKIE_LOGIN_INFO.getKey(),loginInfo,30*24*60*60);
                }
                //session共享用户登录名
                DealSessionUtil.addSessionOne(CookieSessionNameEnum.SESSION_USER_INFO.getaESkey(),userName);
                DealSessionUtil.addSessionOne(CookieSessionNameEnum.SESSION_USER_INFO.getKey(),String.valueOf(userBean.getId()));
                return new ResultBean<UserBean>(DefineCode.CODE_SUCCESS, userBean);
            } else {
                throw new ThrowException(ResultEnum.USER_PWDERROR);
            }

        }


    }

    public List<Map<String,String>> getMenu() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String userId = (String) request.getSession().getAttribute(CookieSessionNameEnum.SESSION_USER_INFO.getKey());

        List<Map<String,String >> map = menuBeanDAO.selectMenuByUserId(userId);

        logger.debug("[menu:]{}",map.toString());

        return map;
    }

//    public void insert(UserBeanTest s) {
//        userBeanDAO.insertss(s);
//    }
























    /**
     * 验证码检测
     * @param
     */
    private void verifyCode(String verifyCode) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //1 获得用户输入的验证码
        //2 获得服务器session 存放数据 ,如果没有返回null
        String sessionCacheData = (String) request.getSession().getAttribute("sessionCacheData");
        // *将服务器缓存session数据移除
        request.getSession().removeAttribute("sessionCacheData");
        // ** 判断服务器是否存在
        if(sessionCacheData == null){
            throw new ThrowException(ResultEnum.USER_RESUBMIT);
        }
        //3 验证码是否填对
        if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
            throw new ThrowException(ResultEnum.USER_VERCodeERROR);
        }
    }
}
