package pers.lish.test;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * create by lishengbo on 2017-12-19 16:24
 */
@Entity
public class bboys {
    @Id
    @GeneratedValue
    private  Integer id;

    private String cupSize;

    private Integer age;

    public bboys() {
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
