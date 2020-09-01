package test.generateUUID;

import java.util.UUID;

/**
 * @function :
 */
public class UuidUtil {
	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String generateUUID() {
		String s = UUID.randomUUID().toString();
		System.err.println(s);
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}
public static void main(String[] args) {
	System.out.println(generateUUID());
}
}
