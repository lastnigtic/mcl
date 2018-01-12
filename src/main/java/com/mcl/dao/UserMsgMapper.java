package com.mcl.dao;

import com.mcl.pojo.UserMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMsg record);

    int insertSelective(UserMsg record);

    UserMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMsg record);


    int updateByPrimaryKey(UserMsg record);

    List<UserMsg> selectList(@Param("openid") String openid,@Param("readstatus") Integer readstatus);
}