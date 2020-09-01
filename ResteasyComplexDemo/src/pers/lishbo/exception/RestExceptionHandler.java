package pers.lishbo.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import pers.lishbo.common.ResultBean;

import com.tsb.ischool.framework.common.ISchoolConstants;
import com.tsb.ischool.framework.exception.ISchoolException;

/**
 * resteasy提供的统一异常处理方法
 */
@Controller
@Provider  
public class RestExceptionHandler implements ExceptionMapper<Exception> {  
	private Logger logger = Logger.getLogger(RestExceptionHandler.class);
    @Override  
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response toResponse(Exception e) {          
        //ResultDto ret = ResultBuilder.buildResultStr(ResultBuilder.FAIL_CODE, null, "-1", e.getMessage()); 
    	String operation = "出现restful全局异常";
    	ResultBean ret = null;
    	try {
    		/** 继承运行时异常，所有在程序运行过程中产生的异常 ，均要经过此转换作为返回接口的信息*/
			ISchoolException iSchoolException = (ISchoolException)e;
			ret= new ResultBean(0,iSchoolException.getPerrorcode(),"",iSchoolException.getPerrormessage());
		} catch (Exception e1) {
			ret = new ResultBean(0,-10000,"",e.getMessage());
			logger.info(ISchoolConstants.LOGGER_PREFIX_ERROR + operation + "e.getMessage()="+e.getMessage());
			e.printStackTrace();
		}
    	
        return Response.ok(ret, MediaType.APPLICATION_JSON).build();  
    }  
} 