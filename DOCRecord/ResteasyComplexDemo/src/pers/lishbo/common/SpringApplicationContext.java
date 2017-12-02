package pers.lishbo.common;
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
	/**
	 * ,获得Spring中定义的Bean实例(对象).可以用:
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	RegisterDAO registerDAO = (RegisterDAO)ac.getBean("RegisterDAO");
		如果是两个以上:
ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","dao.xml"});
或者用通配符:
ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/*.xml");
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {   
    	if(appContext==null){
    			appContext = new ClassPathXmlApplicationContext(springConfigPath);  
    	}
        return appContext.getBean(beanName);   
    } 
}