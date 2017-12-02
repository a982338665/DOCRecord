package pers.lishbo.common;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pers.lishbo.aservice.commonservice.UserService;
import pers.lishbo.aservice.commonservice.impl.UserServiceImpl;
/**
 * 在非controller中获取service实例
 *
 */
public class SpringInit implements ServletContextListener {
    private static WebApplicationContext springContext;    
        public SpringInit() {        
                 super();  
        }    
       public void contextInitialized(ServletContextEvent event) {       
                     springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());   
       }    

       public void contextDestroyed(ServletContextEvent event) {     

       }    

       public static ApplicationContext getApplicationContext() {     
                    return springContext;    
       }
       public static void main(String[] args) {
    	   UserService appcdService1 = new UserServiceImpl() ;
    	   appcdService1.testService();
    	   UserService appcdService = (UserService)SpringInit.getApplicationContext().getBean("UserService");
    	   appcdService.testService();
	}
}