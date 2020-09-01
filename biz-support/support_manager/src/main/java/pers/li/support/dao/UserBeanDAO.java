package pers.li.support.dao;


import org.apache.ibatis.annotations.Param;
import pers.li.support.common.BaseDAO;
import pers.li.support.entity.UserBean;
/**
 * 
 * @author guojiaqing
 *
 */

public interface UserBeanDAO extends BaseDAO<UserBean> {
	
    
    /**
     * 登录--
     * @param userName
     * @return
     */
    UserBean selectByLoginName(@Param("userName")String userName);


//    void insertss(UserBeanTest s);

}