package com.ssm.webrest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;

import com.ssm.util.PropertyUtil;
import com.ssm.util.SpringApplicationContext;

/**
 * 外部接口提供
 * @author 
 *
 */
@Controller
@Path("/wbrest")
public class OutInterfaceRest {/*

	private static IComp_Interface comp;

//	static{
//		comp=(IComp_Interface) SpringApplicationContext.getBean(PropertyUtil.getProperty("comp"));
////		String on_off=PropertyUtil.getProperty("on_off");
////		
////		if("1".equals(on_off)){
////			HxUtil hxUtil = new HxUtil();
////			HuanXinInterfaceService huanXinInterfaceService=(HuanXinInterfaceService) SpringApplicationContext.getBean("huanXinInterfaceService");
////			hxUtil.setHuanXinInterfaceServiceImpl(huanXinInterfaceService);
////			hxUtil.start();
////		}
//	}
	@POST
	@Path("/test")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ResultBean SSTDataReq() {
//		String ysBean=new Gson().toJson(bean);
//		String msg = ISchoolConstants.LOGGER_PREFIX_DEBUG + "THREADID = " + Thread.currentThread().getId() 
//				+ ".|添加机构，学校，年级，班级，学生，老师通用接口.|organizationBean=" + bean.toString() + ".|";
//		logger.debug(msg + "开始验证具体协议");
		Map<String, String> map=new HashMap<String, String>();
		try{
			map = comp.addBbtSST();
			return new ResultBean(Long.parseLong(map.get("ResultCode").toString()), 0, map.get("data"), map.get("ErrorMessage").toString());
		} catch (Exception e) {
			 
			map.put("ErrorMessage", e.toString());
		}finally{
			
//			_addAPILog("sctsdatareq(添加用户接口)",ysBean, map );
		}
		
		return new ResultBean(ResultBean.CODE_ERROR, ErrorCode.ISCHOOL_REQJSON_PARSEMSG_EXCEPTION, null, "系统异常，请稍后重试");
	}
	
	
	
*/}
