package study.datastructure;

import java.util.BitSet;
/**
 * 暂时搁置
 *  位集合类实现了一组可以单独设置和清除的位或标志。
 *  该类在处理一组布尔值的时候非常有用，你只需要给每个值赋值一"位"，然后对位进行适当的设置或清除，就可以对布尔值进行操作了。
 * @author lishengbo
 * @Time 2017年12月8日下午4:45:49
 */
public class BitsetTest {
	  public static void main(String args[]) {
		     BitSet bits1 = new BitSet(16);
		     BitSet bits2 = new BitSet(16);
		      
		     // set some bits
		     for(int i=5; i<18; i++) {
		        if((i%2) == 0) bits1.set(i);
		        if((i%5) != 0) bits2.set(i);
		     }
		     System.out.println("Initial pattern in bits1: ");
		     System.out.println(bits1);
		     System.out.println("\nInitial pattern in bits2: ");
		     System.out.println(bits2);
		 
		     // AND bits
		     bits2.and(bits1);
		     System.out.println("\nbits2 AND bits1: ");
		     System.out.println(bits2);
		 
		     // OR bits
		     bits1.or(bits2);
		     System.out.println("\nbits2 OR bits1: ");
		     System.out.println(bits2);
		 
		     // XOR bits
		     bits2.xor(bits1);
		     System.out.println("\nbits2 XOR bits1: ");
		     System.out.println(bits2);
		  }
}
