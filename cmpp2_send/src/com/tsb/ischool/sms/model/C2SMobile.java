package com.tsb.ischool.sms.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.tsb.ischool.framework.common.ErrorCode;
import com.tsb.ischool.framework.exception.ISchoolException;
/**
 * 
 *  类 名 称：C2SMobile<br>
 *  内容摘要：手机短消息的实体类外部传参接口类<br>
 *  完成日期：<br>
 *  编码作者：Dongrisheng<br>
 */
public class C2SMobile implements Serializable{

	private List<MobileMessage> list;

	public List<MobileMessage> getList() {
		return list;
	}

	public void setList(List<MobileMessage> list) {
		this.list = list;
	}
	
	public boolean verify() throws ISchoolException {
		if (null == this||CollectionUtils.isEmpty(list)) {
			throw new ISchoolException(ErrorCode.ISCHOOL_REQBODY_INVALID_MSGTYPE, "参数错误，入参为空。");
		}
		return true;
	}

	@Override
	public String toString() {
		return "C2SMobile [list=" + list + "]";
	}
	
	
}
