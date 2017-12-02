package test.DigitalDisgn;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

public class SignTest {

	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		String json="{\"access_token\": \"ec9e57913c5b42b282ab7b743559e1b0\","
				   + "\"oauth_consumer_key\": \"10000003\","
			       + "\"formart\": \"json\","
				   + "\"openid\": \"483e74132c9421fca0196d7b94ff0d7a\",}";
		System.out.println("================================================================");
		System.out.println("访问接口的参数:"+json);
		System.out.println("================================================================");
		//参数格式化：access_token及open_id等均进行加密
		@SuppressWarnings("unchecked")
		Map<String, Object> mapJson = JSONObject.fromObject(json);
		Set<String> keyset=mapJson.keySet();
		System.out.println(keyset.size());
		String [] keys =new String[keyset.size()];
		int begin=0;
		for (String keyone : keyset) {
			if(begin<keyset.size()){
				keys[begin]=keyone;
			}
			begin++;
		}
		System.out.println(Arrays.asList(keys));  
		Arrays.sort(keys);
		System.out.println(Arrays.asList(keys));  

//		System.out.println("--------"+keys.toString());
		System.out.println(mapJson.keySet());
		JSONObject jsonObject = JSONObject.fromObject(json);
		System.out.println(jsonObject.toString());
		System.out.println(mapJson.toString());
		String appToken="{\"access_token\":\"65h38edj9943kr934e24\","
						+ "\"open_id\":\"8940kr9u94ir93i9rei3\","
						+ "\"expires_in\":776102321,"
						+ "\"scope\":\" get_user_info,\" \" get_user_class_info\","
						+ "\"state\":\"437673\"}";
		String appkey="njxtqgjyptfromlianchuang";
//		String pp=Coder.encryptHMAC((json).getBytes("utf-8"));
		byte[] pp=Coder.encryptHMAC((json).getBytes("utf-8"), appkey);
		String param=Base64.encode(pp);
		System.out.println(param);
		
		System.out.println("================================");
		for (int i = 0; i < pp.length; i++) {
			System.out.println(pp[i]);
		}
		System.out.println("================================");
		String sig=new BigInteger(pp).toString();
		System.out.println(sig);
//		String sig  =  new BigInteger(Coder.encryptHMAC((param).getBytes("utf-8"), appkey)).toString();
//		解密示例：new Des3(appkey).decode(appToken)
//		byte[] ss=new Des3(appkey).decode(appToken);
//		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText)) ;
//		String s = new String(decryptData, encoding) ;
		
	}
	public static String MIMA(){
		
		
		
		
		
		return null;
	}
}
