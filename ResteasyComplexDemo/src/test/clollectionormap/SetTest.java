package test.clollectionormap;

import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		SetTest dht = new SetTest();
		dht.HashSet();
	}

	public void HashSet() {
		HashSet hs = new HashSet();
		hs.add("a");
		hs.add("b");
		hs.add("b");// 虽然可以通过编译和没报错，但是size()的值是2，说明不能重复加
		hs.add(null);// 可以加入null值，输出的size()值是3
		System.out.println(hs.size());
		TreeSet ts = new TreeSet();
        ts.add("a");
        ts.add("b");
        ts.add("b");//虽然可以通过编译和没报错，但是size()的值是2，说明不能重复加
        //ts.add(null);//报错NullPointException
        System.out.println(ts.size()); 
    }
}