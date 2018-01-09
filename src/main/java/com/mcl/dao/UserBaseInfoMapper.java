package com.mcl.dao;

import com.mcl.pojo.UserBaseInfo;

public interface UserBaseInfoMapper {
    int deleteByPrimaryKey(String openid);

    int insert(UserBaseInfo record);

    int insertSelective(UserBaseInfo record);

    UserBaseInfo selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(UserBaseInfo record);

    int updateByPrimaryKey(UserBaseInfo record);
}