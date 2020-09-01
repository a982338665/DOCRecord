package pers.lishbo.common;

import java.util.HashMap;
import java.util.Map;

import pers.lishbo.util.PropertyUtil;

/**
 * 
 * @author zkl
 * @date 2014-7-17 涓嬪崍3:47:07
 * @version 1.0
 */
public class ISchoolConstants {
	private final static String LOGGER_PREFIX="TSB_ISCHOOL_EXTERNAL_API";
	
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
	public static final String SYN_LC_STUDENTINFO = PropertyUtil.getProperty("xkLogin");	
	public static final String SYN_LC_TEACHERINFO = PropertyUtil.getProperty("xkLogin");	
	
	public static final String XK_STUDENT_DELETE_URL     = PropertyUtil.getProperty("xkStudentDelete");
	public static final String XK_CHANGE_PASSWORD_URL    = PropertyUtil.getProperty("xkChangePassword");
	public static final String XK_LOGIN_URL              = PropertyUtil.getProperty("xkLogin");
	public static final String AUTHENTIFICATIONAPPLY_URL = PropertyUtil.getProperty("authentificationapply");
	public static final String XK_FAMILY_DELETE_URL      = PropertyUtil.getProperty("xkFamilyDelete");
	
	public final static String ROLE_ORDINARYROLEID="commonrole";
	public final static String PMS_ROOTID = "0";
	
	public final static String ORGANIZATIONTYPE_PID = "0";
	
	public final static Integer ORGANIZATIONTYPE_AREA = 30;
	public final static Integer ORGANIZATIONTYPE_SCHOOL = 20;

	public final static Integer ORGANIZATIONTYPE_PROVINCEP = 50;
	public final static Integer ORGANIZATIONTYPE_CITYP = 60;
	public final static Integer ORGANIZATIONTYPE_AREAP = 70;

	public final static Integer DEFAULT_ROLE_TYPE = 59;
	public final static Integer DEFAULT_ROLE_INSERT_TYPE = 58;
    
  
    public static final int SCHOOL_STAGE_PRIMARY=1;
   
    public static final int SCHOOL_STAGE_JUNIOR=2;
  
    public static final int SCHOOL_STAGE_SENIOR=3;
    
	public static final int HOME_TYPE_PROVINCE=5;
	public static final int HOME_TYPE_CITY=6;
	public static final int HOME_TYPE_AREA=7;
	public static final int HOME_TYPE_SCHOOL=3;

	
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
