package study.extend_duotai;
/**
 * 
 * @author lishengbo
 * @Time 2017年12月8日下午3:47:08
 */
public class TestSuperSub{
  public static void main (String args[]){
    SubClass sc = new SubClass();
    SubClass sc2 = new SubClass(200); 
  }
}
class SuperClass {
  private int n;
  SuperClass(){
    System.out.println("SuperClass()"+"初始化");
  }
  SuperClass(int n) {
    System.out.println("SuperClass(int n)"+n);
    this.n = n;
  }
}
class SubClass extends SuperClass{
  private int n;
  
  SubClass(){
	//new子类对象时，子类对象的无参构造会默认调用父类的无参构造，如下：可省略不写，若写只能写在第一行，首先执行
	//super();
	//此处引用父类的有参构造参数，并且总在第一行执行
	super(200);
    System.out.println("SubClass");
  }  
  
  public SubClass(int n){
    System.out.println("SubClass(int n):"+n);
    this.n = n;
  }
}
