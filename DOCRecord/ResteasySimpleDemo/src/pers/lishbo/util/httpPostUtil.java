package pers.lishbo.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

public class httpPostUtil {

	    

	    public static Map<String,String> httpPostUtil2(String url, String filename1) throws UnsupportedEncodingException {
	    	Map<String,String> map=new HashMap<String, String>();
				        HttpClient client = new DefaultHttpClient();  
				        //HttpCore协议的执行 (utf -8)
				        client.getParams().setParameter( CoreProtocolPNames.HTTP_CONTENT_CHARSET,  
				                Charset.forName("UTF-8"));  
				        //创建HttpGet或HttpPost对象，将要请求的URL通过构造方法传入HttpGet或HttpPost对象
				        HttpPost post = new HttpPost(url);  
				        //解决传输过程的中文乱码问题
				        String name = new String(filename1.getBytes("UTF-8"), "UTF-8");  
				        // 创建file对象 fileDirName可以为文件也可以为文件夹
				        File file = new File(name);  
				        // 判断文件或文件夹是否存在
				        if(!file.exists()) {			        
//				            file.createNewFile(); // 创建文件或者文件夹
//				            System.out.println(file.getName() + " 创建成功");
				        	System.err.println("file is not exist！");      
				        }
				        MultipartEntity multipartEntity = new MultipartEntity();  
				        FileBody cbFileBody = new FileBody(file);  
//				        multipartEntity.addPart("file", cbFileBody);  
				        multipartEntity.addPart("file_upload", cbFileBody);  
				  
				        post.setEntity(multipartEntity);  
				        HttpResponse response = null;  
				        String content = null;  
				        try {  
				            response = client.execute(post);  
				            content = EntityUtils.toString(response.getEntity());  
//					        System.err.println("response.getStatusLine().getStatusCode():"+response.getStatusLine().getStatusCode());    //200    
//					        System.err.println(content);  
					        client.getConnectionManager().shutdown();
//					        System.err.println(content);  
					        map.put("pageCode", response.getStatusLine().getStatusCode()+"");
					        map.put("content", content);
					        return map;

				        } catch (ClientProtocolException e) {  
				            // TODO Auto-generated catch block  
				            e.printStackTrace();  
				        } catch (IOException e) {  
				            // TODO Auto-generated catch block  
				            e.printStackTrace();  
				        }
						return map;  
				    
		}  
	    
	    
	    
	  /**
	   * 文件上傳測試  
	   * @param args
	 * @throws IOException 
	   */
	    public static void main(String[] args) throws IOException {  
//			DateBean dd=DateDetailUtil.getDateDetail(new Date());
//
//	    	System.out.println("教师短信量数据统计"+dd.getYear()+"."+dd.getMonth()+"."+dd.getDay());
	    	 String url="http://10.0.0.69:8080/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/getCurrentProvince";
//	 	     String filename1="F:/MessageNUMtest/file.xls";
//	 	     Map<String,String> content=httpPostUtil2(url,filename1);  
//	 	     System.out.println(content.get("content")+content.get("pageCode"));
	    	HttpClient client = new DefaultHttpClient();  
	    	//HttpCore协议的执行 (utf -8)
	        client.getParams().setParameter( CoreProtocolPNames.HTTP_CONTENT_CHARSET,  
	                Charset.forName("UTF-8"));
	      //创建HttpGet或HttpPost对象，将要请求的URL通过构造方法传入HttpGet或HttpPost对象
	        HttpPost post = new HttpPost(url); 
	        HttpResponse response = null;  
	        String content = null;
	        response = client.execute(post);  
            content = EntityUtils.toString(response.getEntity(),"UTF-8"); 
            System.err.println(content);  
	    	
	    }

	}   
	

