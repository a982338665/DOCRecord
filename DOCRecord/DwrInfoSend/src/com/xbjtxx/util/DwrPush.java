package com.xbjtxx.util;

import java.util.Collection;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

/**
 * 消息推送
 * @author lishengbo
 * @Time 2017年12月26日下午4:21:48
 */
public class DwrPush {
	
	public void send(String msg){
		WebContext context=WebContextFactory.get();
		//获取所有页面的scriptsession
		Collection allScriptSessions = context.getAllScriptSessions();
		ScriptBuffer sb=new ScriptBuffer();
		//调用页面回调方法
		sb.appendScript("callback(");
		sb.appendScript(msg);
		System.out.println(1222222222);
		sb.appendScript(")");
		Util util=new Util(allScriptSessions);
		util.addScript(sb);
		
	}
}
