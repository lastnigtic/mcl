package com.mcl.dao;

import com.mcl.pojo.UserBaseInfo;

import java.util.List;

public interface UserBaseInfoMapper {
    int deleteByPrimaryKey(String openid);

    int insert(UserBaseInfo record);

    int insertSelective(UserBaseInfo record);

    UserBaseInfo selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(UserBaseInfo record);

    int updateByPrimaryKey(UserBaseInfo record);

    int checkUserByOpenid(String openid); //查找用户是否存在，存在则不为零

    List<UserBaseInfo> selectList(UserBaseInfo userBaseInfo);

    Integer count();

}