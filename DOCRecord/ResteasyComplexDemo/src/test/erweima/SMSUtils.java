package test.erweima;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SMSUtils {
	/**秘钥*/
	private static String API_KEY = null;
	static {
		// 从配置文件读取秘钥
		ResourceBundle rb = ResourceBundle.getBundle("sms");
		API_KEY = rb.getString("apiKey");
	}
	
	/**单条发送地址--智能匹配模版*/
	private static String URI_SINGLE_SEND 	= "https://sms.yunpian.com/v2/sms/single_send.json";
	/**批量发送相同内容--智能匹配模板*/
	private static String URI_BATCH_SEND 	= "https://sms.yunpian.com/v2/sms/batch_send.json";
	/**批量发送不同内容*/
	private static String URI_MULTI_SEND 	= "https://sms.yunpian.com/v2/sms/multi_send.json";
	/**语音验证码*/
	private static String URI_VOICE_SEND 	= "https://voice.yunpian.com/v2/voice/send.json";
	
	/**签名维护接口地址*/
	private static String URI_SIGN_GET 		= "https://sms.yunpian.com/v2/sign/get.json";
	private static String URI_SIGN_ADD 		= "https://sms.yunpian.com/v2/sign/add.json";
	private static String URI_SIGN_UPDATE 	= "https://sms.yunpian.com/v2/sign/update.json";
	
	/**模板维护接口地址*/
	private static String URI_TPL_ADD 		= "https://sms.yunpian.com/v2/tpl/add.json";
	private static String URI_TPL_DEL 		= "https://sms.yunpian.com/v2/tpl/del.json";
	private static String URI_TPL_UPDATE 	= "https://sms.yunpian.com/v2/tpl/update.json";
	private static String URI_TPL_GET 		= "https://sms.yunpian.com/v2/tpl/get.json";
	
	/**编码格式。发送编码格式统一用UTF-8*/
	private static String ENCODING = "UTF-8";
	
	/**
	 * 单条发送 && 批量发送相同内容
	 * 发送时智能匹配模板
	 * 
	 * @param textOrCode 短信内容或语音验证码, 如果是4-6位数字，则发送语音验证码
	 * @param mobile 接收的手机号,多个号码使用","分隔，语音验证码不支持多号码发送
	 * @return json格式字符串
	 */
	public static String send(String mobile, String textOrCode) {
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("apikey", API_KEY);
			params.put("mobile", mobile);
			
			// 语音验证码为4-6位数字
			String pattern = "^\\d{4,6}$";
			boolean isVoice = Pattern.matches(pattern, textOrCode);
			if ( isVoice ) {
				params.put("code", textOrCode);
				return post(URI_VOICE_SEND, params);
			}
			
			params.put("text", textOrCode);
			// 不包含逗号，为单条发送
			if (mobile.indexOf(",") == -1) {
				return post(URI_SINGLE_SEND, params);
			}
			return post(URI_BATCH_SEND, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 批量发送不同内容
	 * @param mobile
	 * @param textList
	 * @return
	 */
	public static String send(String mobile, List<String> textList) {
		if ( mobile != null && textList != null ) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("apikey", API_KEY);
			params.put("mobile", mobile);
			try {
				StringBuffer sb = new StringBuffer();
				for (String text : textList) {
					sb.append(",").append(URLEncoder.encode(text, ENCODING));
				}
				params.put("text", sb.substring(1));
				return post(URI_MULTI_SEND, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 添加签名
	 * @param sign 签名，不能包含【】，例如“黑马商城”
	 * @return
	 */
	public static String addSign(String sign) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		params.put("sign", sign);
		return post(URI_SIGN_ADD, params);
	}
	
	/**
	 * 更新签名
	 * @param old_sign
	 * @param sign
	 * @return
	 */
	public static String updateSign(String old_sign, String sign) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		params.put("old_sign", old_sign);
		params.put("sign", sign);
		return post(URI_SIGN_UPDATE, params);
	}
	
	/**
	 * 获取签名
	 * @return
	 */
	public static String getSign() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		return post(URI_SIGN_GET, params);
	}
	
	/**
	 * 添加模板
	 * @param tpl_content
	 * @return
	 */
	public static String addTPL(String tpl_content) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		params.put("tpl_content", tpl_content);
		return post(URI_TPL_ADD, params);
	}
	
	/**
	 * 删除模板
	 * @param tpl_id
	 * @return
	 */
	public static String delTPL(String tpl_id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		params.put("tpl_id", tpl_id);
		return post(URI_TPL_DEL, params);
	}
	
	/**
	 * 修改模板
	 * @param tpl_id
	 * @param tpl_content 必须以带符号【】的签名开头
	 * @return
	 */
	public static String updateTPL(String tpl_id, String tpl_content) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		params.put("tpl_id", tpl_id);
		params.put("tpl_content", tpl_content);
		return post(URI_TPL_UPDATE, params);
	}
	
	/**
	 * 获取单个模板
	 * @param tpl_id
	 * @return
	 */
	public static String getTPL(String tpl_id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		params.put("tpl_id", tpl_id);
		return post(URI_TPL_GET, params);
	}
	
	/**
	 * 获取所有模板
	 * @return
	 */
	public static String getTPL() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", API_KEY);
		return post(URI_TPL_GET, params);
	}
	
	/**
	 * 基于HttpClient 4.3的通用POST方法
	 *
	 * @param url 提交的URL
	 * @param paramsMap 提交<参数，值>Map
	 * @return 提交响应
	 */
	private static String post(String url, Map<String, String> paramsMap) {
		CloseableHttpClient client = HttpClients.createDefault();
		String responseText = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost method = new HttpPost(url);
			if (paramsMap != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> param : paramsMap.entrySet()) {
					NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
					paramList.add(pair);
				}
				method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
			}
			response = client.execute(method);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseText = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseText;
	}
}