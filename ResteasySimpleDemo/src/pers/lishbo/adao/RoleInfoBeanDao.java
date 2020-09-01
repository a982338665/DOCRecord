
package pers.lishbo.adao;

import java.util.List;
import java.util.Map;

import pers.lishbo.abean.User;

public interface RoleInfoBeanDao extends BaseDao<User>{
	
    String findAge(String id);

    List<Map<String,String>>  getAllUserInfo();
    
}