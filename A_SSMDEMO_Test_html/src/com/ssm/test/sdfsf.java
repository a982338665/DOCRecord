package com.ssm.test;

import javax.servlet.ServletContext;

import org.apache.ibatis.mapping.Environment;

public class sdfsf {

	public static void main(String[] args) {
		//G:\study—Eclipse workSpace\A_SSMDEMO_Test
		String path = System.getProperty("user.dir").replace("bin", "logs");
		System.out.println(path);
		String path2 = Environment.class.getResource("").getPath();  
		System.out.println(path2);
		String webAppPath = path2.substring(0, path2.toUpperCase().lastIndexOf("WEB-INF/")).replaceAll("%20", " ");  
		
		System.setProperty("webapp",webAppPath + "logs/log.log");  
		System.out.println(webAppPath);
//		String   file_real_path=ServletContext.getRealPath("mypath/filename");  
//		String path3= this.getClass().getResource("/").getPath();  
		
		
	}
}
