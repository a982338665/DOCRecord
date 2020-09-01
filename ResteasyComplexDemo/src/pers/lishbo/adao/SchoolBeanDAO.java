package pers.lishbo.adao;

import pers.lishbo.abean.SchoolBean;

public interface SchoolBeanDAO  {
    int deleteByPrimaryKey(String cSid);

    int insert(SchoolBean record);

    int insertSelective(SchoolBean record);

    SchoolBean selectByPrimaryKey(String cSid);

    int updateByPrimaryKeySelective(SchoolBean record);

    int updateByPrimaryKey(SchoolBean record);
}