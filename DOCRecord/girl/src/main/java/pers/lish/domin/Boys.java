package pers.lish.domin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * create by lishengbo on 2017-12-19 14:03
 */
@Entity
public class Boys {
    @Id
    @GeneratedValue
    private  Integer id;

    private String cupSize;

    private Integer age;

    public Boys() {
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
}
