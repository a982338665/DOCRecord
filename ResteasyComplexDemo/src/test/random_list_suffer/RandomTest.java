package test.random_list_suffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 验证码生成方式
 * @return
 */
public class RandomTest {

	/**
	 * 验证码生成方式
	 * @return
	 */
    private static String generateWord() {    
    	//可以把想要出现的内容填写上
        String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7",    
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",    
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",    
                "W", "X", "Y", "Z","a","b","c","d","e" };    
        //数组转list
        List<String> list = Arrays.asList(beforeShuffle);    
        //洗牌（随机打乱）
        Collections.shuffle(list);    
        StringBuilder sb = new StringBuilder();    
        for (int i = 0; i < list.size(); i++) {    
            sb.append(list.get(i));    
        }    
        String afterShuffle = sb.toString();   
        //生成六位验证码
        String result = afterShuffle.substring(5, 11);    
        return result;    
    }  
    public static void main(String[] args) {
		System.out.println(generateWord());
		System.out.println(generateWord().toLowerCase());
	}
}
