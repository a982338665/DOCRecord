package pers.lishbo.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import pers.lishbo.common.ISchoolConstants;

public class LogTimeFilter implements javax.servlet.Filter {

	protected String encoding = "UTF-8";
	
	protected FilterConfig filterConfig = null;
	
	private static Logger logger= Logger.getLogger(LogTimeFilter.class);

	public void setFilterConfig(FilterConfig config) {
		this.filterConfig = config;
	}
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	public void destroy() {
	    this.encoding = null;
	    this.filterConfig = null;
	}
	
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response,
	                     FilterChain chain) throws IOException,ServletException {
		HttpServletRequest myRequest = (HttpServletRequest)request;
		HttpServletResponse myResponse = (HttpServletResponse)response;
		HttpSession session = myRequest.getSession(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String opration = ISchoolConstants.LOGGER_PREFIX_DEBUG + " currentThread = "+Thread.currentThread().getId() 
				+ " currentTime = " + sdf.format(new Date()) + ".|接受请求之前.";
		logger.debug(opration);
		long startTime = System.currentTimeMillis();
		
		String uri = myRequest.getRequestURI();
		System.out.println("uri------------>"+uri);

//		if(uri.indexOf(".do")==-1 ){
//    	//System.out.println(session.getAttribute("userName"));
//    	if(session.getAttribute("userName")== null && 
//    			myRequest.getRequestURI().indexOf("index.html")==-1 && 
//    					myRequest.getRequestURI().indexOf("login")==-1 
//        		 ){   
//    		myResponse.sendRedirect(myRequest.getContextPath()+"/webpage/page/index.jsp");   
//            return ;   
//        } 
//    }	
		if(uri.indexOf(".do")==-1 ){
    	//System.out.println(session.getAttribute("userName"));
    	if(session.getAttribute("userName")== null && 
    			myRequest.getRequestURI().indexOf("index.html")==-1 && 
    					myRequest.getRequestURI().indexOf("login")==-1 
        		 ){   
    		myResponse.sendRedirect(myRequest.getContextPath()+"/webpage/page/index.jsp");   
            return ;   
        } 
    }	
		
		
//		if(uri.indexOf(".jsp")==-1 ){
//        	//System.out.println(session.getAttribute("userName"));
//        	if(session.getAttribute("userName")== null && 
//        			myRequest.getRequestURI().indexOf("index.html")==-1 && 
//        					myRequest.getRequestURI().indexOf("login")==-1 
//            		 ){   
//        		myResponse.sendRedirect(myRequest.getContextPath()+"/webpage/page/index.jsp");   
//                return ;   
//            } 
//        }	
   
//		System.out.println("uri------------>"+GetRealIp.getIpAddr((HttpServletRequest) request)+":");
	    chain.doFilter(request, response);
	    
	    long endTime = System.currentTimeMillis();
	    long usedTime =0;
		String opration2 = ISchoolConstants.LOGGER_PREFIX_DEBUG + " currentThread = "+Thread.currentThread().getId() 
				+ " currentTime = " + sdf.format(new Date()) + ".|完成请求.";
		logger.debug(opration2);
	
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
	    this.filterConfig = filterConfig;
	    this.encoding = filterConfig.getInitParameter("encoding");
	}
	
	protected String selectEncoding(ServletRequest request) {
	    return (this.encoding);
	}

}
