package pers.li.support.util.rule;

import java.util.HashMap;
import java.util.Map;

/**
 * create by lishengbo on 2018-03-16 11:27
 *
 * 用户信息处理类：
 * 1.用户信息cookie生成规则
 *
 *
 */


public class UserInfoDealUtil {

    /**
     * 生成用户信息cookie的value值
     * @param name
     * @param pwd
     * @return
     */
    public static String getUserCookie(String name,String pwd){
        if(name!=null && pwd!=null){
            return name+"|"+pwd;
        }
        return null;
    }


    public static Map<String,String > GetUserInfo(String userInfo){

        Map<String,String > map=new HashMap<String, String>();

        String[] split = userInfo.split("\\|");
        map.put("userName",split[0]);
        map.put("userPass",split[1]);
        return map;

    }



}
