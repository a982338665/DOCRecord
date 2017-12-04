package com.ssm.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SupportUserAccessFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;   
        HttpServletResponse response = (HttpServletResponse)res;  
        HttpSession session = request.getSession();  
        //以此结尾的通过过滤器========
        //value.indexOf("wer")==-1
        //表示从前向后索引查找是否存在该字符串（wer）,如果没有找到就返回-1，找到即!=-1
        if (request.getRequestURI().indexOf("/API/packageQuery.rest")!=-1){
        	 chain.doFilter(req, res);
        }else if(request.getRequestURI().indexOf("/sendTeacherMessage/send.rest")!=-1){
        	 chain.doFilter(req, res);
        }else{
        	/* if(request.getRequestURI().indexOf(".jsp")!=-1 || request.getRequestURI().indexOf(".do")!=-1){
             	//System.out.println(session.getAttribute("userName"));
             	if(session.getAttribute("userName")== null && 
                 		request.getRequestURI().indexOf("index.html")==-1 && 
                 		request.getRequestURI().indexOf("login")==-1 
                 		 ){   
                     response.sendRedirect(request.getContextPath()+"/index.jsp");   
                     return ;   
                 } 
             }	*/
        	 chain.doFilter(req, res);
        }
       
          
        

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
