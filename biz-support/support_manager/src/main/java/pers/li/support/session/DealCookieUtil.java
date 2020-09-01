package pers.li.support.session;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.li.support.util.AESUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * create by lishengbo on 2018-03-15 13:21
 *
 * 存取session和cookie的工具类
 */
public class DealCookieUtil {


    /**
     * 响应普通cookie不加密
     * @param key
     * @param value
     */
    public static void addCommonCookie(String key,String value,int maxTime){
        HttpServletResponse response =
                ((ServletRequestAttributes)
                        RequestContextHolder.getRequestAttributes()).getResponse();
        Cookie userCookie=new Cookie(key,value);
        //存活期为一个月 30*24*60*60
        userCookie.setMaxAge(maxTime);
        //.setPath("/")表示在该服务器下，任何项目，任何位置都能获取到cookie，
        userCookie.setPath("/");
        response.addCookie(userCookie);
    }


    /**
     * 响应AES加密cookie
     * @param key
     * @param value
     */
    public static void addAESCookie(String key,String value,int maxTime){
        HttpServletResponse response =
                ((ServletRequestAttributes)
                        RequestContextHolder.getRequestAttributes()).getResponse();
//        String encryptKey = AESUtil.encrypt(key);
        String encryptValue = AESUtil.encrypt(value);
        Cookie userCookie=new Cookie(key,encryptValue);
        //存活期为一个月 30*24*60*60
        userCookie.setMaxAge(maxTime);
        //.setPath("/")表示在该服务器下，任何项目，任何位置都能获取到cookie，
        userCookie.setPath("/");
        response.addCookie(userCookie);
    }

    /**
     * 根据cookie的key值获取cookie内容
     * @param key
     */
    public static String getCookie(String key){
        Map<String,String> map=new HashMap<String, String>();
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(key)){
                    String value=cookie.getValue();
                    return value;
                }

            }
        }
        return null;
    }








}
