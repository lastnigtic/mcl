package com.mcl.dao;

import com.mcl.pojo.UserMsg;

public interface UserMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMsg record);

    int insertSelective(UserMsg record);

    UserMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMsg record);

    int updateByPrimaryKeyWithBLOBs(UserMsg record);

    int updateByPrimaryKey(UserMsg record);
}