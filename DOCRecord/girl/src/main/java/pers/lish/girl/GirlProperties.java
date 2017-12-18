package pers.lish.girl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create by lishengbo on 2017-12-18
 * alt+insert 快速生成get，set方法
 */
@Component
@ConfigurationProperties(prefix="girl")
public class GirlProperties {
    private String age;
    private String cupSize;
    private String sex;

    public void setAge(String age) {
        this.age = age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {

        return age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "age='" + age + '\'' +
                ", cupSize='" + cupSize + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
