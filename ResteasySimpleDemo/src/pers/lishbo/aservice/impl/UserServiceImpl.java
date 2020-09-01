package pers.lishbo.aservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.lishbo.adao.UserDao;
import pers.lishbo.aservice.UserService;

@Service
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