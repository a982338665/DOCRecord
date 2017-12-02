package test.random_list_suffer;
import java.util.*;  
/**
 * 随机打乱原来的顺序，和洗牌一样。
 * @author cjh
 *
 */
public class ShuffleTest {  
    public static void main(String[] args) {  
        List<Integer> list = new ArrayList<Integer>();  
        for (int i = 0; i < 10; i++)  
            list.add(new Integer(i));  
        System.out.println("打乱前:");  
        System.out.println(list);  
  
        for (int i = 0; i < 5; i++) {  
            System.out.println("第" + i + "次打乱：");  
            Collections.shuffle(list);  
            System.out.println(list);  
        }  
    }  
}  