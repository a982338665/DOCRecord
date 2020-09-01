package pers.lishbo.awebservice.webservice;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import pers.lishbo.aservice.abstractservice.GanSuService;

/**
 * 甘肃
 */

@Component("GanSuRest")
public class GanSuRest extends CompA {
	
	@Resource 
	private GanSuService gansuService;
	@Override
	public String testKind() {
		System.out.println("子类rest重写父类CompA方法：进入GanSuRest");
		return gansuService.testkind();
	}
	
}
