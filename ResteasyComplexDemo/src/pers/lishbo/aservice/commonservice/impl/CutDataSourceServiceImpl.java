package pers.lishbo.aservice.commonservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.lishbo.adao.SchoolBeanDAO;
import pers.lishbo.adao.SysUrlBeanDAO;
import pers.lishbo.aservice.commonservice.CutDataSourceService;
@Service
public class CutDataSourceServiceImpl implements CutDataSourceService {

	@Resource
	private SchoolBeanDAO schoolbeandao;
	
	@Resource
	private SysUrlBeanDAO sysurlbeandao;
	
	@Override
	public String findSchool(String string) {
		// TODO Auto-generated method stub
		return schoolbeandao.selectByPrimaryKey(string).toString();
	}

	@Override
	public String findurl(String string) {
		// TODO Auto-generated method stub
		return sysurlbeandao.selectByPrimaryKey(Integer.valueOf(string)).toString();
	}

}
