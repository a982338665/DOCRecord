
package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.bean.User;

public interface RoleInfoBeanDao extends BaseDao<User>{
	
    String findAge(String id);

    List<Map<String,String>>  getAllUserInfo();
    
}