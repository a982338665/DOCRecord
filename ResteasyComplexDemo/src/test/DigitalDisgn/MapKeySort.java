package test.DigitalDisgn;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * Map的key值排序
 * @author cjh
 *
 */
public class MapKeySort {


    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
        public int compare(String obj1, String obj2) {
             // 降序排序
        	return obj1.compareTo(obj2);
                    }
                });
        map.put("b", "ccccc");
        map.put("d", "bbbbb");
        map.put("e", "aaaa");
        map.put("a", "ddddd");

        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }

    }

}
