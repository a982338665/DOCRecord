package pers.li.test;

import java.util.ArrayList;

/**
 * create by lishengbo on 2018-05-02 11:28
 */
public class SessionUtil {


    public static Object getUserSessionId(ArrayList<UserDetail> userList,String sessionId) {
        for (int i = 0; i <userList.size() ; i++) {
            UserDetail userDetail = userList.get(i);
            if(userDetail.getSessionIdString().equals(sessionId)){
                return userDetail;
            }
        }
        return null;

    }
}
