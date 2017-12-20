package pers.lish.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * create by lishengbo on 2017-12-19 14:03
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private  Integer id;
    private String cupSize;

    /**
     * 表单验证，年龄最小为18
     */
    @Min(value = 18,message = "未成年少女静止入内")
    private Integer age;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
