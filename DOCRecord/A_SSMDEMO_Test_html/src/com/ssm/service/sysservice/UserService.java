package com.ssm.service.sysservice;

import java.util.List;
import java.util.Map;

public interface UserService {
	
    String findAge(String id);

    List<Map<String,String>>  getAllUserInfo();
}