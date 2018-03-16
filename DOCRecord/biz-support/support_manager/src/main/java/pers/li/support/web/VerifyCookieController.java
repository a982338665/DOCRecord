package pers.li.support.web;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.li.support.common.DefineCode;
import pers.li.support.common.DefineMould;
import pers.li.support.common.ResultBean;
import pers.li.support.entity.UserBean;
import pers.li.support.enums.ResultEnum;
import pers.li.support.exception.ThrowException;
import pers.li.support.service.LoginService;
import pers.li.support.session.CookieSessionNameEnum;
import pers.li.support.session.DealCookieUtil;
import pers.li.support.util.AESUtil;
import pers.li.support.util.rule.UserInfoDealUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * create by lishengbo on 2018-01-02 17:42
 */
@Controller//放入Spring容器
@RequestMapping("/verify")
public class VerifyCookieController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/SelectCookie.rest",
            method = RequestMethod.GET
    )
    @ResponseBody
    public ResultBean<Map<String,String>> exposer(HttpServletRequest req) /*throws Exception*/{
       /* req.getHeaders("Cookie");
        logger.debug("[req:]{}",req.getCookies());
        Cookie[] cookies = req.getCookies();
        for (Cookie s:
             cookies) {
            logger.debug("[req:-key]{}",s.getName()+"|"+s.getValue());
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.debug("[【request】]{}",request.getCookies());
        Cookie[] cookies2 = request.getCookies();
        for (Cookie s:
                cookies2) {
            logger.debug("[req:-key]{}",s.getName()+"|"+s.getValue());
        }*/
        try {
            //获取用户信息加密的cookie的key值
            String key = CookieSessionNameEnum.COOKIE_LOGIN_INFO.getKey();
            //获取cookie对应的加密value值
            String cookie = DealCookieUtil.getCookie(key);
            //解密
            String user= AESUtil.decrypt(cookie);
            Map<String, String> stringStringMap = UserInfoDealUtil.GetUserInfo(user);
            return new ResultBean<Map<String, String>>(DefineCode.CODE_SUCCESS,stringStringMap);
        } catch (Exception e) {
            throw new ThrowException(ResultEnum.USER_COOKIEERROR);
        }

    }


}
