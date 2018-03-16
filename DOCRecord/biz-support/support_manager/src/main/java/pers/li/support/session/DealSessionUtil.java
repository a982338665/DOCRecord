package pers.li.support.session;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.li.support.util.AESUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * create by lishengbo on 2018-03-15 13:21
 *
 * 存取session和cookie的工具类
 */
public class DealSessionUtil {


    /**
     * 单个session共享
     * @param key
     * @param value
     */
    public static void addSessionOne(String key,String value){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }
    /**
     * 所有session共享
     */
    public static void addSessionAll(Map<String,String> map){

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        for (String key : map.keySet()) {
            //map.keySet()返回的是所有key的值
            String value = map.get(key);//得到每个key多对用value的值
            session.setAttribute(key, value);
        }
    }









}
