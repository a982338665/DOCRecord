package pers.lishbo.aservice.commonservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.lishbo.adao.RoleInfoBeanDao;
import pers.lishbo.aservice.commonservice.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private RoleInfoBeanDao roleinfobeandao;

	@Override
	public String findAge(String id) {
		// TODO Auto-generated method stub
		return roleinfobeandao.findAge(id);
	}

	@Override
	public List<Map<String, String>> getAllUserInfo() {
		// TODO Auto-generated method stub
		return roleinfobeandao.getAllUserInfo();
	}

	@Override
	public void testService() {
		System.out.println("--------");
	}

}
