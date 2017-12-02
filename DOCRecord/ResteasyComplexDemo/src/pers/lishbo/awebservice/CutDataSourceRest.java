package pers.lishbo.awebservice;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import pers.lishbo.aservice.commonservice.CutDataSourceService;
import pers.lishbo.datasource.DataSourceConst;
import pers.lishbo.datasource.DataSourceContextHolder;
/**
 * 数据源切换测试rest
 * @author cjh
 *
 */
@Controller
@Path("/cutdatasource")
public class CutDataSourceRest {


	private Logger logger = Logger.getLogger(CutDataSourceRest.class.getName());
//	private static IComp_Interface comp;

	@Resource
	private CutDataSourceService cutdatasourceservice;
	
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
	 * 测试数据源切换
	 * @return
	 */
	@POST
	@Path("/test.rest")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public String SSTDataReq() {
		try{
			//查询t_s_school
			DataSourceContextHolder.setDataSourceType(DataSourceConst.getXuekuSource());
			String school=cutdatasourceservice.findSchool("01a1e4657ffb4150bdf7098fac6a047c");
			DataSourceContextHolder.setDataSourceType(DataSourceConst.getSupportSource());
			String url=cutdatasourceservice.findurl("1");
			
			return school+"|||"+url;
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
