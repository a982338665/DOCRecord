package pers.lishbo.adao;

import pers.lishbo.abean.SysUrlBean;

public interface SysUrlBeanDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUrlBean record);

    int insertSelective(SysUrlBean record);

    SysUrlBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUrlBean record);

    int updateByPrimaryKey(SysUrlBean record);
}