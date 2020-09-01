package pers.li.support.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *<b>AES 加密/解密 for 甘肃</b><br>
 * <B>注意：</B><br>
 * 调用方法参见main方法，需要事先指定偏移量 iv和密钥参数，这种方法密钥必须是16位的<br>
 * @author Dongrisheng
 *
 */
public class AESUtil {

	public static  String key = "XXTxkforEduZHuuu";
	public static  String iv  = "5017629898423448";

	/**
	 * 偏移量获取
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static IvParameterSpec getIV() throws UnsupportedEncodingException {
		return new IvParameterSpec(iv.getBytes());
	}

	/**
	 * 密钥生成
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static SecretKeySpec getKey()   {
 		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
		return keySpec;
	}

	/**
	 * 解密
	 * 
	 * @return
	 */
	public static String decrypt(String src) {
		try {

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, getKey(), getIV());
			byte[] decodedByte = new BASE64Decoder().decodeBuffer(src);
			byte[] original = cipher.doFinal(decodedByte);
			String result = new String(original);
			return result;
		} catch(IOException e){
			System.out.println(e.toString());
		} catch (IllegalBlockSizeException e) {
			System.out.println(e.toString());
		} catch (BadPaddingException e) {
			System.out.println(e.toString());
		} catch (InvalidKeyException e) {
			System.out.println(e.toString());
		} catch (InvalidAlgorithmParameterException e) {
			System.out.println(e.toString());
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.toString());
		} catch (NoSuchPaddingException e) {
			System.out.println(e.toString());
		};

		return null;
	}

	/**
	 * 加密
	 * 
	 * @param content
	 * @return
	 */
	public static String encrypt(String content) {

		try {

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, getKey(), getIV());
			byte[] contentByte = content.getBytes();
			byte[] result = cipher.doFinal(contentByte);
			return new BASE64Encoder().encode(result);
		} catch (IllegalBlockSizeException e) {
			System.out.println(e.toString());
		} catch (BadPaddingException e) {
			System.out.println(e.toString());
		} catch (InvalidKeyException e) {
			System.out.println(e.toString());
		} catch (InvalidAlgorithmParameterException e) {
			System.out.println(e.toString());
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.toString());
		} catch (NoSuchPaddingException e) {
			System.out.println(e.toString());
		};

		return null;
	}

	

	 
	/**
	 * 调用的测试主方法
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String content = "201333";

		AESUtil.iv="5017629898423448";
		AESUtil.key="XXTxkforEduZHuuu";
		// 加密
		System.out.println("加密前：" + content);
		String resultString = AESUtil.encrypt(content);
		System.out.println("加密后：" + resultString);
		// 解密
		String decryptResult = AESUtil.decrypt("ja2f6V0+FvT3m8jvL1oa3w==");
		System.out.println("解密后：" + decryptResult);
		//String dd="Pzx+XRr+gxARgJ8nEEE78g\u003d\u003d";
		//System.out.println("密文:"+dd+",解密后：" + AESUtil.decrypt(dd));
	}

}
