package pers.lishbo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;

public class CharacterEncodingFilter implements Filter {

	private static final String ENCODING_UTF_8 = "UTF-8";

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    request.setCharacterEncoding(ENCODING_UTF_8);
	    response.setCharacterEncoding(ENCODING_UTF_8);
	    request.setAttribute(InputPart.DEFAULT_CHARSET_PROPERTY, ENCODING_UTF_8);
	    chain.doFilter(request, response);
	}
}
