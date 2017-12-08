package study.datastructure;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  栈（Stack）实现了一个后进先出（LIFO）的数据结构。
	你可以把栈理解为对象的垂直分布的栈，当你添加一个新元素时，就将新元素放在其他元素的顶部。
	当你从栈中取元素的时候，就从栈顶取一个元素。换句话说，最后进栈的元素最先被取出。
	push存值
	pop取值
 * @author lishengbo
 * @Time 2017年12月8日下午5:07:28
 *  1   boolean empty() 
    测试堆栈是否为空。
    2 	Object peek( )
    查看堆栈顶部的对象，但不从堆栈中移除它。
    3 	Object pop( )
    移除堆栈顶部的对象，并作为此函数的值返回该对象。
    4 	Object push(Object element)
    把项压入堆栈顶部。
    5 	int search(Object element)
    返回对象在堆栈中的位置，以 1 为基数。
 */
public class Stack_Test {

    static void showpush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }
 
    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }
 
    public static void main(String args[]) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
