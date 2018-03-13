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

        if (request.getRequestURI().indexOf("/API/packageQuery.rest")!=-1){
        	 chain.doFilter(req, res);
        }else if(request.getRequestURI().indexOf("/sendTeacherMessage/send.rest")!=-1){
        	 chain.doFilter(req, res);
        }else{
        	 if(request.getRequestURI().indexOf(".html")!=-1 || request.getRequestURI().indexOf(".rest")!=-1){
             	//System.out.println(session.getAttribute("userName"));
             	if(session.getAttribute("userName")== null &&
                 		request.getRequestURI().indexOf("index.html")==-1 &&
                 		request.getRequestURI().indexOf("login")==-1
                 		 ){
                     response.sendRedirect(request.getContextPath()+"/webpage/pages/login/login.html");
                     return ;
                 }
             }
        	 chain.doFilter(req, res);
        }




	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
