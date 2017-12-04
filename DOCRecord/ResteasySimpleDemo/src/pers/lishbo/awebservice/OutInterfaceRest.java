package pers.lishbo.awebservice;

import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import pers.lishbo.aservice.UserService;

/**
 * @author 
 *
 */
@Controller
@Path("/wbrest")
public class OutInterfaceRest {

	private Logger logger = Logger.getLogger(OutInterfaceRest.class.getName());
//	private static IComp_Interface comp;

	@Resource
	private UserService userservice;
	
	static{
//		comp=(IComp_Interface) SpringApplicationContext.getBean(PropertyUtil.getProperty("comp"));
//		String on_off=PropertyUtil.getProperty("on_off");
//		
//		if("1".equals(on_off)){
//			HxUtil hxUtil = new HxUtil();
//			HuanXinInterfaceService huanXinInterfaceService=(HuanXinInterfaceService) SpringApplicationContext.getBean("huanXinInterfaceService");
//			hxUtil.setHuanXinInterfaceServiceImpl(huanXinInterfaceService);
//			hxUtil.start();
//		}
	}
	/**
	 * 测试MVC,不传参
	 * @return
	 */
	@POST
	@Path("/testMVC.rest")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public String SSTDataReq() {
		try{
			String age=userservice.findAge("1");
			return age;
		} catch (Exception e) {
			//捕获异常并手动处理，如果不做处理，不报错不解决，无返回值
			e.printStackTrace();
			//System.exit(-1);---退出系统，停止服务
		}finally{
			//finally为总会执行，除非在catch块里出行System.exit(-1);
		}
		return null;
	}
	
	/**
	 * 测试统一异常处理方法处理接口
	 * @return
	 */
	@POST
	@Path("/test.rest")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public String SSTDastaReq() {
		try{
			int s=1/0;
			return "123";
		} catch (Exception e) {
			//捕获异常并手动处理，如果不做处理，不报错不解决，无返回值
			//e.printStackTrace();
			//System.exit(-1);---退出系统，停止服务
		}finally{
			//finally为总会执行，除非在catch块里出行System.exit(-1);
		}
		return null;
	}
	/**
	 * 测试MVC,传参字符串
	 * @return
	 */
	@POST
	@Path("/testMVCStr.rest")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public String SSTDatasReq(String s) {
		
		try{
			String age=userservice.findAge(s);
			logger.debug("【参数】:"+s+"||"+"【结果】:"+age);
			return age;
		} catch (Exception e) {
			//捕获异常并手动处理，如果不做处理，不报错不解决，无返回值
			e.printStackTrace();
			//System.exit(-1);---退出系统，停止服务
		}finally{
			//finally为总会执行，除非在catch块里出行System.exit(-1);
		}
		return null;
	}
	
	/**
	 * 测试MVC,传参json
	 * @return
	 */
	@POST
	@Path("/testMVCMap.rest")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public String SSTDatasReq(Map<String,String> ss) {
		String s=ss.get("sid");
		try{
			String age=userservice.findAge(s);
			logger.debug("【参数】:"+ss.toString()+"||"+"【结果】:"+age);
			return age;
		} catch (Exception e) {
			//捕获异常并手动处理，如果不做处理，不报错不解决，无返回值
			e.printStackTrace();
			//System.exit(-1);---退出系统，停止服务
		}finally{
			//finally为总会执行，除非在catch块里出行System.exit(-1);
		}
		return null;
	}
}
