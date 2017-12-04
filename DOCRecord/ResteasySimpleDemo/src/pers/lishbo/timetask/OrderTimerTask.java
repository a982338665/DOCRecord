package pers.lishbo.timetask;

import java.text.ParseException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderTimerTask {

	@Scheduled(cron = "0 0/59 * * * ?")//   0 0/15 * * * ?    0 */1 * * * ?
	public void clientInfoTimer() throws ParseException {
		
		
	}
}
