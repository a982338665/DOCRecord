package pers.li.support.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pers.li.support.common.DefineCode;
import pers.li.support.common.ResultBean;
import pers.li.support.exception.ThrowException;

/**
 * create by lishengbo on 2017-12-20 14:04
 * 异常捕获全局====未指定包名扫描时，
 * 此处书写不同级----指定扫描包即可
 *
 * pers.li.support.handle.ExceptionHandle
 */
//@RestController
//@EnableWebMvc
//@ControllerAdvice
public class ExceptionHandle {
//
////    /**定义要捕获异常的类为Exception*/
////    @ExceptionHandler(value = GirlException.class)
////    /**以接口格式输出*/
////    @ResponseBody
////    public ResultBean handle(GirlException e){
////        return ResultUtil.error(e.getCode(),e.getMessage());
////    }
//    /**
//     * 日志的打印
//     */
//    private  final static Logger log= LoggerFactory.getLogger(ExceptionHandle.class);
////    /**定义要捕获异常的类为Exception*/
////    @ExceptionHandler(value = ThrowException.class)
////    /**以接口格式输出*/
////    @ResponseBody
////    public ResultBean handle(ThrowException e){
////        log.error("[系统异常]{}",e);
////        if(e instanceof ThrowException){
////            ThrowException ee=(ThrowException)e;
////            String message = ee.getMessage();
////            return new ResultBean<String>(ee.getCode(),message);
////        }else{
////            log.error("[系统异常]{}",e);
////            return new ResultBean<String>(DefineCode.CODE_SYSTEM_ERROR,e.getStackTrace()[0].toString());
////        }
////    }
//    /**定义要捕获异常的类为Exception*/
//    @ExceptionHandler(value = Exception.class)
//    /**以接口格式输出*/
//    @ResponseBody
//    public ResultBean handle(Exception e){
//        log.error("[系统异常]{}",e);
//        if(e instanceof ThrowException){
//            ThrowException ee=(ThrowException)e;
//            String message = ee.getMessage();
//            return new ResultBean<String>(ee.getCode(),message);
//        }else{
//            log.error("[系统异常]{}",e);
//            return new ResultBean<String>(DefineCode.CODE_SYSTEM_ERROR,e.getStackTrace()[0].toString());
//        }
//    }
//    /**
//     * 获取异常信息的错误位置，行数，及出错方法
//     */
////    public String getExceptionDetail(Exception e){
////        StackTraceElement stackTraceElement= e.getStackTrace()[0];
////
//////        System.out.println("File="+stackTraceElement.getFileName());
//////        System.out.println("Line="+stackTraceElement.getLineNumber());
//////        System.out.println("Method="+stackTraceElement.getMethodName());
////    }
}
