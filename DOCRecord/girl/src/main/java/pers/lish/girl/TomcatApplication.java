package pers.lish.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 配合war包使用
 * --打成war可直接放在tomcat中运行
 * create by lishengbo on 2017-12-21 17:38
 */
@SpringBootApplication
public class TomcatApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GirlApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
