package pers.lishbo.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import pers.lishbo.util.jsontojson.ResultStudentInfotBean;
import pers.lishbo.util.jsontojson.ResultUserInfotBean;

import com.google.gson.Gson;

/**
 * json字符串转复杂对象及简单对象
 * 
 *
 */
public class JSONtoObject {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		String json="{\"ret\":0,\"userInfo\":{\"picture\":\"http:jpg\",\"birthday\":\"2016-04-20\",\"sex\":1,"
				+ "\"studentData\":[{\"birthday\":\"\",\"sex\":1,\"classId\":10001677,\"updateTime\":\"2015-02-10 14:39:14\","
				+ "\"userId\":600003574,\"studentName\":\"wyuu168\",\"kindred\":2,\"thirdUserId\":\"12345678\"},"
				+ "{\"birthday\":\"\",\"sex\":1,\"classId\":10001656,\"updateTime\":\"2015-02-10 14:43:38\",\"userId\":600003671,"
				+ "\"studentName\":\"wyuu2655\",\"kindred\":0,\"thirdUserId\":\"123456789\"}],\"updateTime\":\"2016-04-05 11:18:41\","
				+ "\"nickName\":\"13645157783\",\"userId\":21280785,\"userType\":1,\"openId\":\"530c3ebd06fa8cb733a12019c094e596\"},\"msg\":\"成功！\"}";
		System.out.println(json);
		Map<Object,Object> jsonObject2 = JSONObject.fromObject(json);
		System.err.println("返回的个人信息数据："+jsonObject2.toString());
		Object familyData=jsonObject2.get("userInfo");
		System.err.println("家长信息数据："+familyData.toString());
		JSONObject familyOb = JSONObject.fromObject(new Gson().toJson(familyData));
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("studentData", ResultStudentInfotBean.class);
		ResultUserInfotBean userInfo= (ResultUserInfotBean) JSONObject.toBean(familyOb, ResultUserInfotBean.class,classMap);
		System.err.println("家长成功转换为对象："+userInfo.toString());
//		

//		JsonConfig jsonConfig = new JsonConfig();
//	    jsonConfig.setRootClass(ReciveRequestUserParam.class);
//	    Map<String, Class> stuMap = new HashMap<String, Class>();  
//      classMap.put("studentData", ResultStudentInfotBean.class);
//      jsonConfig.setClassMap(stuMap);  
//	    ReciveRequestUserParam userbean = (ReciveRequestUserParam) JSONSerializer.toJava(jsonObject2, jsonConfig);
//		System.err.println("个人信息："+userbean.toString());
//		//获取班级信息接口=====================================
//		String json1="{\"id\":\"1212\",\"name\":\"sdfafdf\"}";
//		StuBean s=JsonTOBean(json1,StuBean.class);
//		System.out.println(s.toString());
//		StuBean s1=JsonTOJavaBean(json1,StuBean.class);
//		System.out.println(s1.toString());
//		System.err.println("-------------------------------------------");
//		String json2="{\"id\":\"1212\",\"name\":\"sdfafdf\",\"userif\":{\"idd\":\"1212\",\"username\":\"sdfafdf\"}}";
//		System.err.println(json2);
//		StuBean s2=JsonTOJavaBean2(json2,StuBean.class,UserInfo.class,"userif");
//		System.out.println(s2.toString());
		
	}
	
	
	/**
	 * json转对象1，
	 * 如果属性中含有复杂的类型，当其中属性有类似List , Map ,ArrayList、自定义的类型，如List<Teacher> teachers, 就不可以使用此方法
	 * @return 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T>T JsonTOBean(String json,Class cla){
		JSONObject familyOb = JSONObject.fromObject(json);
		T userInfo= (T) JSONObject.toBean(familyOb,cla);	
		return userInfo;
	}
	/**
	 * json转对象2，
	 * 如果属性中含有复杂的类型，当其中属性有类似List , Map ,ArrayList、自定义的类型，如List<Teacher> teachers, 就不可以使用此方法
	 * @return 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T>T JsonTOJavaBean(String json,Class cla){
		JSONObject familyOb = JSONObject.fromObject(json);
		JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.setRootClass(cla);
	    T userbean = (T)JSONSerializer.toJava(familyOb, jsonConfig);
		return userbean;
	}
	

	/**
	 *  json转对象3，--暂不可用
	 * 如果属性中含有复杂的类型，当其中属性有类似实体类使用此方法
	 * @param json
	 * @param claOuter
	 * @param claInner
	 * @param innerName
	 * @return
	 */
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public static <T>T JsonTOJavaBean2(String json,Class claOuter, Class claInner,String innerName){
		Map<Object,Object> jsonObject2 = JSONObject.fromObject(json);
//		Object familyData=jsonObject2.get("userInfo");
//		System.err.println("家长信息数据："+familyData.toString());
//		JSONObject familyOb = JSONObject.fromObject(new Gson().toJson(familyData));
		Map<String, Class> usMap = new HashMap<String, Class>();
		usMap.put(innerName, claInner);
		JSONObject familyOb = JSONObject.fromObject(json);
		T userInfo= (T) JSONObject.toBean(familyOb, claOuter,usMap);
//	    T userInfo= (T) JSONObject.toBean(familyOb,cla);
		return userInfo;
	}
	
	
	
	
	
	
	
}
