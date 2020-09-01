package com.ssm.configuration;

import java.util.HashMap;
import java.util.Map;

import com.ssm.util.PropertyUtil;

public class FixedConfiguration {

	private final static String LOGGER_PREFIX="A_SSMDEMO_Test";
	
	public  static Map<String,String> USER_ONLINE_MAP=new HashMap<String,String>();
	
	public final static String LOGGER_PREFIX_ERROR="ERROR_PG_"+LOGGER_PREFIX+".|";
	
	public final static String LOGGER_PREFIX_DEBUG="DEBUG_PG_"+LOGGER_PREFIX+".|";
	
	public final static String LOGGER_PREFIX_INFO="INFO_PG_"+LOGGER_PREFIX+".|";
	
	public final static String LOGGER_PREFIX_WARN="WARN_PG_"+LOGGER_PREFIX+".|";
	
	public final static boolean IS_DEV=Boolean.valueOf(PropertyUtil.getProperty("is_dev","false"));
	
	public final static String REFUSE_URL=PropertyUtil.getProperty("refuse_url");

	public final static  String SESSION_CURRENT_USER = PropertyUtil.getProperty("SESSION_CURRENT_USER");
	
	public final static  String USER_INIT_SCORE = PropertyUtil.getProperty("USER_INIT_SCORE");
	
	public final static  String SYNC_ORG_ADMIN_URL= PropertyUtil.getProperty("SYNC_ORG_ADMIN_URL");
	
	public final static  String SCHOOL_ROLE_NAME= PropertyUtil.getProperty("SCHOOL_ROLE_NAME");

	public final static  String ORGANIZATION_ROLE_NAME= PropertyUtil.getProperty("ORGANIZATION_ROLE_NAME");
	
	public final static  String SCHOOL_ADMIN_ROLE_NAME= PropertyUtil.getProperty("SCHOOL_ADMIN_ROLE_NAME");

	public final static  String ORGANIZATION_ADMIN_ROLE_NAME= PropertyUtil.getProperty("ORGANIZATION_ADMIN_ROLE_NAME");
	
	public final static  String TEACHER_ROLE_NAME= PropertyUtil.getProperty("TEACHER_ROLE_NAME");
	
	public final static  String STUDENT_ROLE_NAME= PropertyUtil.getProperty("STUDENT_ROLE_NAME");
	/**
	 * add by houp 20161101 同步平台学生信息至联创接口
	 * http://221.130.6.212:2688/classSpace/app/xkapi/xkSaveStudent
	 */
	public static final String SYN_LC_STUDENTINFO = PropertyUtil.getProperty("xkLogin");	
	/**
	 * add by houp 20161101 同步平台教师信息至联创接口
	 * http://221.130.6.212:2688/classSpace/app/xkapi/xkSaveTeacher
	 */
	public static final String SYN_LC_TEACHERINFO = PropertyUtil.getProperty("xkLogin");	
	
	/**配置文件中的：学生删除接口（联创提供给学酷，由学酷调用）*/
	public static final String XK_STUDENT_DELETE_URL     = PropertyUtil.getProperty("xkStudentDelete");
	/**配置文件中的：修改密码接口（联创提供给学酷，由学酷调用）*/
	public static final String XK_CHANGE_PASSWORD_URL    = PropertyUtil.getProperty("xkChangePassword");
	/**配置文件中的：注册老师、学生审核接口（联创提供给学酷，由学酷调用）*/
	public static final String XK_LOGIN_URL              = PropertyUtil.getProperty("xkLogin");
	/**配置文件中的：用户认证申请通过接口（由学酷平台提供，内部调用）*/
	public static final String AUTHENTIFICATIONAPPLY_URL = PropertyUtil.getProperty("authentificationapply");
	/**配置文件中的：删除家长接口（联创提供给学酷，由学酷调用）*/
	public static final String XK_FAMILY_DELETE_URL      = PropertyUtil.getProperty("xkFamilyDelete");
	
	/**
	 * 普通角色id
	 * hepeixiao 2015年1月5日16:06:55
	 */
	public final static String ROLE_ORDINARYROLEID="commonrole";
	/**
	 * 权限的顶级id
	 */
	public final static String PMS_ROOTID = "0";
	
	public final static String ORGANIZATIONTYPE_PID = "0";//在子平台管理中 置pid为0表示顶级平台
	
	public final static Integer ORGANIZATIONTYPE_AREA = 30;
	public final static Integer ORGANIZATIONTYPE_SCHOOL = 20;

	public final static Integer ORGANIZATIONTYPE_PROVINCEP = 50;
	public final static Integer ORGANIZATIONTYPE_CITYP = 60;
	public final static Integer ORGANIZATIONTYPE_AREAP = 70;

	public final static Integer DEFAULT_ROLE_TYPE = 59;// 内置的一些固定角色，后台不让删除
	public final static Integer DEFAULT_ROLE_INSERT_TYPE = 58;// 后台管理人员创建角色
    
    /**
     * 小学
     */
    public static final int SCHOOL_STAGE_PRIMARY=1;
    /**
     * 初中
     */
    public static final int SCHOOL_STAGE_JUNIOR=2;
    /**
     * 高中
     */
    public static final int SCHOOL_STAGE_SENIOR=3;
    
	public static final int HOME_TYPE_PROVINCE=5;//(0=省,1=市,2=区,3=学校,4=平台)
	public static final int HOME_TYPE_CITY=6;//(0=省,1=市,2=区,3=学校,4=平台)
	public static final int HOME_TYPE_AREA=7;//(0=省,1=市,2=区,3=学校,4=平台)
	public static final int HOME_TYPE_SCHOOL=3;//(0=省,1=市,2=区,3=学校,4=平台)
//	public static final int HOME_TYPE_PLATFORM=4;//(0=省,1=市,2=区,3=学校,4=平台)
	
	
	public static final Map<Integer, Integer> map_ORGTYPE_HOMETYPE=new HashMap<Integer, Integer>();
	static {
		map_ORGTYPE_HOMETYPE.put(ORGANIZATIONTYPE_AREA, HOME_TYPE_AREA);
		map_ORGTYPE_HOMETYPE.put(ORGANIZATIONTYPE_SCHOOL, ORGANIZATIONTYPE_SCHOOL);
		map_ORGTYPE_HOMETYPE.put(ORGANIZATIONTYPE_PROVINCEP, HOME_TYPE_PROVINCE);
		map_ORGTYPE_HOMETYPE.put(ORGANIZATIONTYPE_CITYP, HOME_TYPE_CITY);
		map_ORGTYPE_HOMETYPE.put(ORGANIZATIONTYPE_AREAP, HOME_TYPE_AREA);
	}
	
	public static final String AES_KEY = PropertyUtil.getProperty("AES_KEY");// "XXTxkforEduZHuna";
	public static final String AES_IV  = PropertyUtil.getProperty("AES_IV");//"5017629898423858";

}
