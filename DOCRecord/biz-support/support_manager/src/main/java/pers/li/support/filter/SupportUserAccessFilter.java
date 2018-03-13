package pers.li.support.filter;

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

/**
 * 登录过滤=============================================
 *
 *
 */
public class SupportUserAccessFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession();
		//		没有此字符串时返回-1，否则返回第一次出现此字符串的索引
		/** 需要放行的接口   ***/
        if (request.getRequestURI().contains("/API/packageQuery.rest")){
        	 chain.doFilter(req, res);
        }else if(request.getRequestURI().contains("/sendTeacherMessage/send.rest")){
        	 chain.doFilter(req, res);
        }else{
        	 if(request.getRequestURI().contains(".html") || request.getRequestURI().contains(".rest")){
             	//System.out.println(session.getAttribute("userName"));
				 /**没有存session，并且请求路径不包含index和login的都重定向到登录页*/
             	if(session.getAttribute("userName")== null &&
						!request.getRequestURI().contains("index.html") &&
                 		!request.getRequestURI().contains("login")
                 		 ){
                     response.sendRedirect(request.getContextPath()+"/webpage/pages/login/login.html");
                     return ;
                 }
             }

             /**其余类型接口均可以正常访问++++++++++++++++++++++++++++++++++++*/
        	 chain.doFilter(req, res);
        }




	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
