package com.ssm.util;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Service
public class SpringApplicationContext {   
    
    private static ApplicationContext appContext = null;    
    static String springConfigPath = "classpath*:../ApplicationContext.xml"; 
    
    // Private constructor prevents instantiation from other classes   
    private SpringApplicationContext() {}   
    
    public void setApplicationContext(ApplicationContext applicationContext)   
            throws BeansException {   
        appContext = applicationContext;   
    
    }   
    
    public static ApplicationContext getAppContext() {
		return appContext;
	}

	public static void setAppContext(ApplicationContext appContext) {
		SpringApplicationContext.appContext = appContext;
	}

	public static Object getBean(String beanName) {   
    	if(appContext==null){
    			appContext = new ClassPathXmlApplicationContext(springConfigPath);  
    	}
        return appContext.getBean(beanName);   
    } 
}