package test.filepath;

import java.io.File;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 项目路径测试
 * @author cjh
 *
 */
public class testPath {
	
	/**
	 * 应用在web项目中的路径获取：地址为tomcat部署项目的路径，根目录下
	 * 如：tomcat/webapp/ResteasyComplexDemo/datamould/
	 */
	@Test
	public void sdfsf(){
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		String path=servletContext.getRealPath("/")+"datamould" +File.separator;
		//判断文件路径不存在创建路径
		if(!Paths.get(path).toFile().exists()){  
            Paths.get(path).toFile().mkdirs();  
        } 		
		System.out.println(path);
//		String file = path+File.separator+fileName+".xls";
	}
	/**
	 * 获取当前文件所在项目的路径
	 * G:\study—Eclipse workSpace1\ResteasyComplexDemo
	 * G:\study—Eclipse workSpace1\ResteasyComplexDemo
	 */
	@Test
	public void sdsfsf() {
		File directory = new File("");// 设定为当前文件夹
		try {
			System.out.println(directory.getCanonicalPath());// 获取标准的路径
			System.out.println(directory.getAbsolutePath());// 获取绝对路径
		} catch (Exception e) {
		}
	}
	/**
	 * 获取当前文件所在项目的路径
	 *G:\study—Eclipse workSpace1\ResteasyComplexDemo\config\resourceBundle.properties
	 *G:\study—Eclipse workSpace1\ResteasyComplexDemo\config\resourceBundle.properties
	 */
	@Test
	public void sas() {	
		
		String proFilePath = System.getProperty("user.dir") +"\\config\\resourceBundle.properties";  
		System.out.println(proFilePath);
    }
	/**
	 * 获取.class文件所在项目的路径
	 * G:\study—Eclipse workSpace1\ResteasyComplexDemo
	 * G:\study—Eclipse workSpace1\ResteasyComplexDemo
	 */
	@Test
	public void sdsfssf() {
		System.out.println(getClass().getResource("").getFile().toString());
		System.out.println(getClass().getResource(".").getFile().toString());
		System.out.println(getClass().getResource("../").getFile().toString());
		System.out.println(getClass().getResource("/").getFile().toString());
		/**
		 *  /G:/study%e2%80%94Eclipse%20workSpace1/ResteasyComplexDemo/build/classes/test/filepath/
			/G:/study%e2%80%94Eclipse%20workSpace1/ResteasyComplexDemo/build/classes/test/filepath/
			/G:/study%e2%80%94Eclipse%20workSpace1/ResteasyComplexDemo/build/classes/test/
			/G:/study%e2%80%94Eclipse%20workSpace1/ResteasyComplexDemo/build/classes/
		 */
	}
}
