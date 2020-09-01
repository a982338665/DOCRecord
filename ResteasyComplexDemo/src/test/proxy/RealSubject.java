package test.proxy;
/**
 * 定义了一个类来实现这个接口，这个类就是我们的真实对象，RealSubject类
 * @author cjh
 *
 */
public class RealSubject implements Subject {
	
	public RealSubject() {
		System.err.println("创建实例对象:RealSubject");
	}
	@Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }
    
    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }}
