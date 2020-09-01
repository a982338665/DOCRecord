package pers.lishbo.timetask;

import java.text.ParseException;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pers.lishbo.aservice.commonservice.CutDataSourceService;
/**
 * spring定时任务
 * @author cjh
 *
 */
@Component
public class OrderTimerTask {
	/**
	 * 
	 * spring中定时器支持service注入
	 * 
	 * */
	@Resource
	private CutDataSourceService cutdatasourceservice;
	@Scheduled(cron = "0 0/59 * * * ?")//   0 0/15 * * * ?    0 */1 * * * ?
	public void clientInfoTimer() throws ParseException {
		
	
		
		
		
	}
}
