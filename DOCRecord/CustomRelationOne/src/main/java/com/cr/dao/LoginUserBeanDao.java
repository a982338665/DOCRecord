package com.cr.dao;




import com.cr.entity.LoginUserBean;

import java.util.Map;

public interface LoginUserBeanDao {

    LoginUserBean login(Map<String, String> map);
}