package com.mcl.dao;

import com.mcl.pojo.UserAvgAbility;
import com.mcl.pojo.UserScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserScore record);

    int insertSelective(UserScore record);

    UserScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserScore record);

    int updateByPrimaryKey(UserScore record);

    int isCompanyHaveAuthorityScoreUser(@Param("openid") String openid,@Param("companyid") String companyid,@Param("joid") Integer joid);

    UserAvgAbility getUserAvgAbility(@Param("openid") String openid);

    List<UserScore> selectList(UserScore userScore);
}