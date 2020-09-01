package pers.li.support.dao;


import org.apache.ibatis.annotations.Param;
import pers.li.support.common.BaseDAO;
import pers.li.support.entity.MenuBean;

import java.util.List;
import java.util.Map;

public interface MenuBeanDAO extends BaseDAO<MenuBean> {
	/**
	 * 获取所有对象
	 * @return
	 */
	List<MenuBean> getAllBean();

	List<Map<String,String >> selectMenuByUserId(@Param("userId")String userId);


}