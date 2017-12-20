package pers.lish.girl.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.lish.girl.domain.ResultBean;
import pers.lish.girl.exception.GirlException;
import pers.lish.girl.utils.ResultUtil;

/**
 * create by lishengbo on 2017-12-20 14:04
 * 异常捕获全局
 */
@ControllerAdvice
public class ExceptionHandle {
//    /**定义要捕获异常的类为Exception*/
//    @ExceptionHandler(value = GirlException.class)
//    /**以接口格式输出*/
//    @ResponseBody
//    public ResultBean handle(GirlException e){
//        return ResultUtil.error(e.getCode(),e.getMessage());
//    }
    /**
     * 日志的打印
     */
    private  final static Logger log= LoggerFactory.getLogger(ExceptionHandle.class);
    /**定义要捕获异常的类为Exception*/
    @ExceptionHandler(value = Exception.class)
    /**以接口格式输出*/
    @ResponseBody
    public ResultBean handle(Exception e){
        if(e instanceof  GirlException){
            GirlException ee=(GirlException)e;
            return ResultUtil.error(ee.getCode(),ee.getMessage());
        }else{
            log.error("[系统异常]{}",e);
            return ResultUtil.error(-1,e.getStackTrace()[0].toString());
        }
    }
    /**
     * 获取异常信息的错误位置，行数，及出错方法
     */
//    public String getExceptionDetail(Exception e){
//        StackTraceElement stackTraceElement= e.getStackTrace()[0];
//
////        System.out.println("File="+stackTraceElement.getFileName());
////        System.out.println("Line="+stackTraceElement.getLineNumber());
////        System.out.println("Method="+stackTraceElement.getMethodName());
//    }
}
