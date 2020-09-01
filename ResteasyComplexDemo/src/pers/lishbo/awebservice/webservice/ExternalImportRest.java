package pers.lishbo.awebservice.webservice;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import pers.lishbo.aservice.commonservice.UserService;
import pers.lishbo.common.ISchoolConstants;
import pers.lishbo.common.SpringApplicationContext;
import pers.lishbo.util.AESUtil;
import pers.lishbo.util.PropertyUtil;



@Controller
@Path("/externalImportRest")
public class ExternalImportRest {
	private static Logger logger = Logger.getLogger(ExternalImportRest.class);
	private static IComp comp;
	@Resource
	private UserService userservice;
	static{
		AESUtil.iv=ISchoolConstants.AES_IV;
		AESUtil.key=ISchoolConstants.AES_KEY;
		String compStr=PropertyUtil.getProperty("comp");
		logger.error("platform:"+compStr);
		//获取spring管理的实例化后的对象
		comp=(IComp) SpringApplicationContext.getBean(compStr);	
	}
	/**
	 * 测试多平台实现
	 * @return
	 */
	@POST
	@Path("/test.rest")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public String SSTDataReq() {
//		Map<String, String> map=new HashMap<String, String>();
		String naaa=comp.testKind();
		return naaa;
	}
	public static void main(String[] args) {
		System.out.println(PropertyUtil.getProperty("comp"));
	}
}
