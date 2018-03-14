package pers.li.support.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * 过滤器一般用于登录权限验证、资源访问权限控制、敏感词汇过滤、字符编码转换等等操作，便于代码重用，不必每个servlet中还要进行相应的操作。
 *
 */
public class SupportUserAccessFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(SupportUserAccessFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession();

//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");

		String path=request.getRequestURI();
		Integer userName=(Integer)session.getAttribute("userName");

		//		没有此字符串时返回-1，否则返回第一次出现此字符串的索引
//		logger.debug("[请求路径记录]{}",request.getRequestURI());
		/** 需要放行的接口   ***/
//		if (path.endsWith("VerifyCode")&&!path.contains("support_manager")){
//
//		}
		if (path.endsWith(".css")||path.endsWith(".js")||
				path.endsWith(".ttf")||!path.endsWith(".gif")||
						path.endsWith(".png")){
			chain.doFilter(req, res);//放行，递交给下一个过滤器
			return;
		}

		/***/
		/**登录页面不过滤***/
		if(path.endsWith("/login.html")){
			chain.doFilter(req, res);//放行，递交给下一个过滤器
			return;
		}
		/**已经登录不过滤***/
		if(userName!=null){
			chain.doFilter(req, res);//放行，递交给下一个过滤器
			return;
		}else{
			response.sendRedirect(request.getContextPath()+"/webpage/pages/login/login.html");
			return ;
		}




	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
