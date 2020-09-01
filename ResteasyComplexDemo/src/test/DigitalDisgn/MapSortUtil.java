package test.DigitalDisgn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSortUtil {

	/* *************************************************************************************
	 * public static Map<String,String> sortMapAtoZ(Map<String,String> map){
	 *	
	 *	return map = new TreeMap<String, String>(new Comparator<String>() {
	 *       public int compare(String obj1, String obj2) {
	 *            // 降序排序
	 *      	return obj1.compareTo(obj2);
	 *                  }
	 *                });
	 *	
	 *}
	 *
	 *public static Map<String,String> sortMapZtoA(Map<String,String> map){
	 *	
	 *	return map = new TreeMap<String, String>(new Comparator<String>() {
	 *        public int compare(String obj1, String obj2) {
	 *             // 降序排序
	 *        	return obj2.compareTo(obj1);
	 *                    }
	 *                });
	 *}
	 **************************************************************************************/
	/**
	 * map中的Value值逆序Z_A
	 * @param map
	 * @return
	 */
	public static Map<String,String> ValuesortMapZtoA(Map<String,String> map){
//		 Map<String, String> map = new TreeMap<String, String>();
//	        map.put("a", "cdddd");
//	        map.put("c", "abbbb");
//	        map.put("d", "aaaaa");
//	        map.put("b", "ccccc");
	        //这里将map.entrySet()转换成list
	        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
	        //然后通过比较器来实现排序
	        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
	            //升序排序
	            public int compare(Entry<String, String> o1,Entry<String, String> o2) {
	                return o1.getValue().compareTo(o2.getValue());
	            }
	        });
	        Map<String,String> mapSort=new TreeMap<String,String>();
	        for(Map.Entry<String,String> mapping:list){ 
	        	mapSort.put(mapping.getKey(), mapping.getValue());
//	            System.out.println(mapping.getKey()+":"+mapping.getValue()); 
	          } 
			return mapSort;
//		
	}
	
	/**
	 * map中的Value值顺序A_Z
	 * @param map
	 * @return
	 */
	public static Map<String,String> ValuesortMapAtoZ(Map<String,String> map){
//		 Map<String, String> map = new TreeMap<String, String>();
//	        map.put("a", "cdddd");
//	        map.put("c", "abbbb");
//	        map.put("d", "aaaaa");
//	        map.put("b", "ccccc");
	        //这里将map.entrySet()转换成list
	        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
	        //然后通过比较器来实现排序
	        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
	            //升序排序
	            public int compare(Entry<String, String> o1,Entry<String, String> o2) {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        });
			
	        Map<String,String> mapSort=new TreeMap<String,String>();
	        for(Map.Entry<String,String> mapping:list){ 
	        	mapSort.put(mapping.getKey(), mapping.getValue());
//	               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
	          } 
	        return mapSort;
	}
	
	
	
	public static void main(String[] args) {
		Map<String,String> map=new TreeMap<String, String>();;
			map.put("b", "ccccc");
	        map.put("d", "aaaaa");
	        map.put("c", "bbbbb");
	        map.put("a", "ddddd");
	        System.out.println(map.toString());
	        Map<String,String> map1=MapSortUtil.ValuesortMapAtoZ(map);
	        System.out.println(map1.toString());
	        Map<String,String> map2=MapSortUtil.ValuesortMapZtoA(map);
	        System.out.println(map2.toString());

		
		
		//=============================================
      /*  Map<String, String> map = new TreeMap<String, String>();
        map.put("a", "cdddd");
        map.put("c", "abbbb");
        map.put("d", "aaaaa");
        map.put("b", "ccccc");
        //这里将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Entry<String, String> o1,Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String,String> mapping:list){ 
               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
          } 
*/
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
