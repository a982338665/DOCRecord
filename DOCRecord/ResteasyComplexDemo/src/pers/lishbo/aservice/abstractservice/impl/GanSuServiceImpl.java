package pers.lishbo.aservice.abstractservice.impl;

import org.springframework.stereotype.Service;

import pers.lishbo.aservice.abstractservice.ImportA;
/**
 * service实现类
 *
 */
@Service("gansuService")//引用此service时，必须使用此名字：private GanSuService gansuService;
public class GanSuServiceImpl extends ImportA {

	@Override
	public String testkind() {
		System.out.println("重写父类ImportA的方法,执行此service内容");
		return "testKind:gansuService";
	}

}
