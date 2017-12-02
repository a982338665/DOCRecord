package test.propertiesFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 *  properties文件读取工具类
 * @author
 * @date 2014-7-17 下午3:48:06
 * @version 1.0
 */
public class PropertyUtil {

	/**
	 * final修饰的类不能被继承
	 * final修饰的方法不能被重写	
	 * final修饰的变量值不可被改变
	 */
//	static Logger logger = Logger.getLogger(PropertyUtil.class.getName());

	public static final String DEFAULT_PROPERTY_FILE = "sql.properties";

	private static Properties props = new Properties();

	static {
		load(DEFAULT_PROPERTY_FILE);
	}

	private static void load(String name) {
		InputStream is = PropertyUtil.class.getResourceAsStream("/" + name);
		try {
			try {
				props.load(is);
			} catch (Exception e) {
//				logger.error();
			}
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				// ignore
			}
		}
	}

	public static String getProperty(String key) {
		String result = props.getProperty(key);
		if (result != null && result.startsWith("@")) {
			result = getProperty(result.substring(1));
		}
		return result;
	}

	public static String getProperty(String key, String defaultValue) {
		String result = props.getProperty(key, defaultValue);
		if (result != null && result.startsWith("@")) {
			result = getProperty(result.substring(1), defaultValue);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(PropertyUtil.getProperty("mess"));
	}
}
