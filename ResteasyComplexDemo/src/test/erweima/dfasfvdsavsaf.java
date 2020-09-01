package test.erweima;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class dfasfvdsavsaf {
	

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s="李生波";
		System.out.println(URLDecoder.decode(s, "utf-8"));
		System.out.println(URLEncoder.encode(s, "GBK"));;
}
}
