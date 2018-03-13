//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pers.li.support.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogTimeFilter implements Filter {
    protected String encoding = "UTF-8";
    protected String logFlag = "true";
    protected String timeDebug = "1";
    protected String timeInfo = "2";
    protected String timeError = "10";
    public FilterConfig filterConfig = null;
    private static Logger logger = LoggerFactory.getLogger("LogTime");

    public LogTimeFilter() {
    }

    public void setFilterConfig(FilterConfig config) {
        this.filterConfig = config;
    }

    public FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    public void destroy() {
        this.encoding = null;
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest myRequest = (HttpServletRequest)request;
        HttpServletResponse myResponse = (HttpServletResponse)response;
        boolean flag = this.logFlag != null && !"".equals(this.logFlag) ? Boolean.parseBoolean(this.logFlag) : false;
        int tDebug = this.timeDebug != null && !"".equals(this.timeDebug) ? Integer.parseInt(this.timeDebug) : 0;
        int tInfo = this.timeInfo != null && !"".equals(this.timeInfo) ? Integer.parseInt(this.timeInfo) : 0;
        int tError = this.timeError != null && !"".equals(this.timeError) ? Integer.parseInt(this.timeError) : 0;
        String oprationStr = "接口调用消耗时间统计";
        long startTime = System.currentTimeMillis();
        String uri = myRequest.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (flag) {
            String opration = oprationStr + "| uri = " + uri + "| currentThread = " + Thread.currentThread().getId() + "| currentTime = " + sdf.format(new Date()) + ".|接受请求之前.";
            logger.debug(opration);
        }

        chain.doFilter(request, response);
        if (flag) {
            long usedTime = System.currentTimeMillis() - startTime;
            String opration2 = oprationStr + "| uri = " + uri + "| currentThread = " + Thread.currentThread().getId() + "| currentTime = " + sdf.format(new Date()) + ".|完成请求. | 消耗时间是：usedTime = " + usedTime + " ms";
            if (usedTime > (long)tError && tError > 0) {
                logger.error(opration2);
                System.out.println("--------------->" + tError);
            } else if (usedTime > (long)tInfo && tInfo > 0) {
                logger.info(opration2);
                System.out.println("--------------->" + tInfo);
            } else if (usedTime > (long)tDebug && tDebug > 0) {
                logger.debug(opration2);
                System.out.println("--------------->" + tInfo);
            } else {
                logger.debug("---------------未匹配上日志的时间级别-------------");
            }
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
        this.logFlag = filterConfig.getInitParameter("logFlag");
        this.timeDebug = filterConfig.getInitParameter("timeDebug");
        this.timeInfo = filterConfig.getInitParameter("timeInfo");
        this.timeError = filterConfig.getInitParameter("timeError");
        System.out.println("--------------->" + this.logFlag);
        System.out.println("--------------->" + this.timeDebug);
    }

    protected String selectEncoding(ServletRequest request) {
        return this.encoding;
    }
}
