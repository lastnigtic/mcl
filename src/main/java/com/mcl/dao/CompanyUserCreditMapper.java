package com.mcl.dao;

import com.mcl.pojo.CompanyUserCredit;

public interface CompanyUserCreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyUserCredit record);

    int insertSelective(CompanyUserCredit record);

    CompanyUserCredit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyUserCredit record);

    int updateByPrimaryKey(CompanyUserCredit record);
}