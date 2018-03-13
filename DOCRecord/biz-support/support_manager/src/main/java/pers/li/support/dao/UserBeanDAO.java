package pers.li.support.dao;



import org.apache.ibatis.annotations.Param;
import pers.li.support.common.BaseDAO;
import pers.li.support.entity.UserBean;

import java.util.List;
import java.util.Map;
/**
 * 
 * @author guojiaqing
 *
 */

public interface UserBeanDAO extends BaseDAO<UserBean> {
	
    
    /**
     * 登录--
     * @param loginName
     * @return
     */
    UserBean selectByLoginName(@Param("loginName")String loginName);


}