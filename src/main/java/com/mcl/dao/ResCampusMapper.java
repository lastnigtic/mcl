package com.mcl.dao;

import com.mcl.pojo.ResCampus;

public interface ResCampusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResCampus record);

    int insertSelective(ResCampus record);

    ResCampus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResCampus record);

    int updateByPrimaryKeyWithBLOBs(ResCampus record);

    int updateByPrimaryKey(ResCampus record);
}