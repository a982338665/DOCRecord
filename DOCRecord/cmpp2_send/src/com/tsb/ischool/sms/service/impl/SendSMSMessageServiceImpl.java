package com.tsb.ischool.sms.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tsb.cmpp2.msg.util.MsgContainer;
import com.tsb.ischool.framework.common.ISchoolConstants;
import com.tsb.ischool.sms.model.C2SMobile;
import com.tsb.ischool.sms.model.MobileMessage;
import com.tsb.ischool.sms.service.ISendSMSMessageService;
import com.tsb.ischool.utils.UuidUtil;

/**
 * 类 编 号： <br>
 * 类 名 称：SendSMSMessageServiceImpl<br>
 * <b>内容摘要：发送手机短消息的实现类</b><br>
 * 完成日期：<br>
 * 编码作者：Dongrisheng<br>
 */
@Service("sendSMSMessageService")
public class SendSMSMessageServiceImpl implements ISendSMSMessageService {
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public int toSendBatchMessage(C2SMobile c2sMobile) {
		 
		int iSendOk =0;
		String operation = ISchoolConstants.LOGGER_PREFIX_DEBUG + "THREADID = "
  				+ Thread.currentThread().getId() + ".|发送手机短信.|list="
  				+ c2sMobile.toString() + ".|";
  		 logger.debug(operation + "开始.|");
  		 c2sMobile.verify();//验证传入的手机短信列表是否为空
         boolean result = false;
         for(int i=0;i<c2sMobile.getList().size();i++){
        	 MobileMessage mm = c2sMobile.getList().get(i);
        	 mm.setId(UuidUtil.generateUUID());
        	 mm.setType("1");
        	 result = SendMsgQueue.getInstance().pushDetry(mm);
        	 if (result){
        		 iSendOk ++;
        	 }
         }
         logger.debug(operation + "开始.|");
         return iSendOk;
         
         
	}

}
