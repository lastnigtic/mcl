package com.mcl.dao;

import com.mcl.pojo.CompAvgAbility;
import com.mcl.pojo.CompanyScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyScore record);

    int insertSelective(CompanyScore record);

    CompanyScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyScore record);

    int updateByPrimaryKey(CompanyScore record);

    int isUserScoredCompany(@Param("openid") String openid,@Param("companyid") String companyid);

    CompAvgAbility getCompAvgAbitlity(@Param("companyid")String companyid);

    List<CompanyScore> selectList(CompanyScore companyScore);

}