package pers.lish.girl.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.lish.girl.domain.Girl;

import java.util.List;

/**
 * create by lishengbo on 2017-12-19 16:49
 */
public interface GirlReponsitory extends JpaRepository<Girl,Integer> {

    //通过年龄查询拓展
    public List<Girl> getByAge(Integer age);
}
