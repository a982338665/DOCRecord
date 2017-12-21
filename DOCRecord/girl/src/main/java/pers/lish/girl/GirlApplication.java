package pers.lish.girl;

//@SpringBootApplication
public class GirlApplication {

	/**
	 * 启动方式1-----不使用tomcat启动方式
	 * @param args
	 */
//	public static void main(String[] args) {
//		SpringApplication.run(GirlApplication.class, args);
//	}
	/**
	 *命令启动：
	 * maven spring-boot run:
	 * java -jar 生成jar包的名称
	 *
	 * 若要用命令来执行，且不更改配置文件则：
	 * java -jar girl-0.0.1-SNAPSHOT.jar --spring.profiles.active=deve
	 * 以上命令将运行开发环境项目；
	 * 换成prod则为生产环境项目
	 */

}
