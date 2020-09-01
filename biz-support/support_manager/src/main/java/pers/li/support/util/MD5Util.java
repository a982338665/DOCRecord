package pers.li.support.util;

/**
 * @function : 
 * @author   :Administrator
 * @company  :天士博
 * @date     :2011-4-30
 */

import java.security.MessageDigest;

public class MD5Util {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// System.out.println((int)b);
				// 将没个数(int)b进行双字节加密
				//96957453484b14e9b7dc8321afd2e083
				//96957453484b14e9b7db8321aad2e083
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] arg) {
//ab2033872386fbff5bd98bac5352226d原始密码
		System.out
				.println(MD5("123456"));
	}

}