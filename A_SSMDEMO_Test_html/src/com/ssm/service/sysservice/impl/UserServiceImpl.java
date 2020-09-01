package com.ssm.service.sysservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.UserDao;
import com.ssm.service.sysservice.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{   
    @Resource
    public UserDao userMapper;
    @Override
    public String findAge(String id) {	
        // TODO Auto-generated method stub
        String age =userMapper.findAge(id);
        return age;
    }
	@Override
	public List<Map<String,String>>  getAllUserInfo() {
		// TODO Auto-generated method stub
		List<Map<String,String>>  age =userMapper.getAllUserInfo();
	     return age;
	}

}