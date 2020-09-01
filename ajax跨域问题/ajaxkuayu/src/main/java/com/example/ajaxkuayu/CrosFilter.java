package com.example.ajaxkuayu;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by lishengbo on 2018-02-27 17:20
 */
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res=(HttpServletResponse)servletResponse;

//        res.addHeader("Access-Control-Allow-Origin","http://localhost:8081");
//        res.addHeader("Access-Control-Allow-Methods","GET");
        /**
         * 以下表示允许所有url及方法跨域访问：
         * 当存在带cookie的跨域时，Access-Control-Allow-Origin参数不能为*,需要明确指定请求发出地址，
         * 此时，使用别的地址就无法正常调用，故为解决这个问题，则需要引入request
         * 报错如下：
         * Failed to load http://localhost:8080/test/getCookie: The value of the
         * 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*'
         * when the request's credentials mode is 'include'. Origin 'http://localhost:8081'
         * is therefore not allowed access. The credentials mode of requests initiated by
         * the XMLHttpRequest is controlled by the withCredentials attribute
         *
         */
        /**带cookie跨域需要改动的地方:cookie指的是调用方的cookies即客户端/
        /******************************************/
//        res.addHeader("Access-Control-Allow-Origin","http://localhost:8081");
//        res.addHeader("Access-Control-Allow-Credentials","true");
        /******************************************/
        /**既支持cookie跨域，又支持别的地址跨域的解决方案：*/
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        String origin=req.getHeader("Origin");
        if(!StringUtils.isEmpty(origin)){
            res.addHeader("Access-Control-Allow-Origin",origin);
        }
        res.addHeader("Access-Control-Allow-Credentials","true");
        /******************************************/


//        res.addHeader("Access-Control-Allow-Origin","*");
        res.addHeader("Access-Control-Allow-Methods","*");
        /**
         * 非简单请求通过预检命令的条件
         */
//        res.addHeader("Access-Control-Allow-Headers","content-type");
        /**
         * 加入自定义头:最好不写死，所以解决方案如下--------------------------------------------
         * 支持所有自定义头---
         */
//        res.addHeader("Access-Control-Allow-Headers","content-type,x-header1,x-header2");
        String headers=req.getHeader("Access-Control-Request-Headers");
        if(!StringUtils.isEmpty(headers)){
            res.addHeader("Access-Control-Allow-Headers",headers);
        }
        /**
         * -----------------------------------------------------------------------------
         */
        /**
         * 将预检命令进行缓存，在下次请求时不进行预检，降低预检对系统效率的影响
         * 值为数字，单位为秒（此处1小时为例）
         */
        res.addHeader("Access-Control-Max-Age","3600");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
