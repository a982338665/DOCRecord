package pers.lish.girl.aspect;

import org.springframework.stereotype.Component;

/**
 * create by lishengbo on 2017-12-22 12:14
 */
@Component
public class Aspect_Content {

    public void chackAccess(){
        String user=CurrentHolder.get();

        if(user.equals("李生波")){
            System.out.println("禁止登陆");
        }else{
            System.out.println("恭喜登陆");
        }
    }
}
