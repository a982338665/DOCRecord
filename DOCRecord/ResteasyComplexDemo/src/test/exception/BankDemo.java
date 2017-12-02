package test.exception;

//文件名称 BankDemo.java
public class BankDemo {

	public static void main(String[] args) {
		CheckingAccount c = new CheckingAccount(101);
		System.out.println("Depositing $500...");
		c.deposit(500.00);
		try {
			System.out.println("\nWithdrawing $100...");
			c.withdraw(100.00);
			System.out.println("\nWithdrawing $600...");
			c.withdraw(600.00);
		} catch (InsufficientFundsException e) {
			System.out.println("Sorry, but you are short $" + e.getAmount());
			/** 主要可以用来打印出问题所在的行数 */
			e.printStackTrace();
			System.out.println(e.getMessage());
			/**
			 * 	InsufficientFundsException
				//类名.方法名（文件名：抛出异常的代码所在行数）
				at CheckingAccount.withdraw(CheckingAccount.java:25)
				//类名。方法名（文件名：catch到异常的代码所在行数）
				at BankDemo.main(BankDemo.java:13)
			 */
			// public String getMessage()
			// 返回关于发生的异常的详细信息。这个消息在Throwable 类的构造函数中初始化了。
			// public Throwable getCause()
			// 返回一个Throwable 对象代表异常原因。
			// public String toString()
			// 使用getMessage()的结果返回类的串级名字。
			// public void printStackTrace()
			// 打印toString()结果和栈层次到System.err，即错误输出流。
			// public StackTraceElement [] getStackTrace()
			// 返回一个包含堆栈层次的数组。下标为0的元素代表栈顶，最后一个元素代表方法调用堆栈的栈底。
			// public Throwable fillInStackTrace()
			// 用当前的调用栈层次填充Throwable 对象栈层次，添加到栈层次任何先前信息中。
		}
	}
}