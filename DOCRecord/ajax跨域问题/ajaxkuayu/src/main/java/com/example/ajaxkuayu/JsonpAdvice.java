package com.example.ajaxkuayu;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * create by lishengbo on 2018-02-27 16:01
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{
    public JsonpAdvice() {
        /**
         * 与前台服务器约定好的路径参数：
         *get1?callback=jQuery191038100058542052073_1519719324860&_=1519719324861
         * &后面的参数随机，防止结果被缓存，如要缓存，则需在client端，添加缓存为true
         */
        super("callback");
        /**
         * 此处若为callback2,则相应的前台参数jsonp也要为callback2
         */
//        super("callback2");

    }
}
