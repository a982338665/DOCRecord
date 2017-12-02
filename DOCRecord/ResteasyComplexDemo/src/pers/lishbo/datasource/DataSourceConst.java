package pers.lishbo.datasource;

/**
 * 获取动态数据源key类
 * @author gongjk
 *
 */
public class DataSourceConst {
	//static Properties props = null;
	//public static String admin_source_key = "admin";
	//public static String ext_source_key = "ext";
	
    /*public enum DataSourceType {
    	support, xueku,sa,res,busi;
    }*/

	public static String getSupportSource() {
		return "dataSource_support";
	}

	public static String getXuekuSource() {
		return "dataSource_xueku";
	}
	public static String getSaSource() {
		return "dataSource_sa";
	}
	public static String getResSource() {
		return "dataSource_res";
	}
	public static String getBusiSource() {
		return "dataSource_busi";
	}

}
