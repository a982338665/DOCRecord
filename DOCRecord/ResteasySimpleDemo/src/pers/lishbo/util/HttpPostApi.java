package pers.lishbo.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

public class HttpPostApi {
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> postApi(String url,String canshu){
		HttpClient client = new DefaultHttpClient();  
		client.getParams().setParameter( CoreProtocolPNames.HTTP_CONTENT_CHARSET,  
                Charset.forName("UTF-8"));
		HttpPost post = new HttpPost(url); 
        HttpResponse response = null;  
        String content = null;
        
        
        
        Map<String,Object> map=new HashMap<String, Object>();
        try {
        	
            if(canshu!=null){  
            	post.addHeader("Content-type","application/json; charset=utf-8");  
            	post.setHeader("Accept", "application/json"); 
              //设置参数到请求对象中  
                post.setEntity(new StringEntity(canshu, "UTF-8"));
            }
        	response = client.execute(post);  
            content = EntityUtils.toString(response.getEntity(),"UTF-8"); 
            map = JSONObject.fromObject(content);
			map.put("pageCode", response.getStatusLine().getStatusCode()+"");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
		
	}

	
	public static void main(String[] args) {
		String url="http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/changeTeacherInfo";
//		String url="http://10.0.0.69:8080/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/getCurrentProvince";
		String canshu="{\"teacherBean\":{\"schoolId\":\"719946\",\"teacherId\":\"20421524\",\"teacherName\":\"郭清泉\",\"teacherPhone\":\" \",\"teacherZh\":\"20421524\",\"teacherPwd\":\"z8EASkuTJWeGNN5JFRIJTw\u003d\u003d\",\"roleCode\":\"29\",\"teacherCTD\":\"2\",\"teachInfoBean\":[{\"classId\":\"720159\",\"className\":\"03班\",\"gradeNum\":\"16\",\"kcode\":\"29\"}]}}";
		
		
		Map<String, Object> postApi = postApi(url,canshu);
//		Map<String, String> postApi = PostApi(url,null);
//		String data = postApi.get("data");
		String errorMessage = (String) postApi.get("errorMessage");
		System.out.println(new String(errorMessage.getBytes(Charset.forName("ISO-8859-1"))));//jdk1.6+  

		System.out.println(errorMessage);
//		JSONObject fromObject = JSONObject.fromObject(string);
//		String code = fromObject.getString("code");
//		System.out.println(code);
//		System.out.println(postApi.toString());
	}

}
