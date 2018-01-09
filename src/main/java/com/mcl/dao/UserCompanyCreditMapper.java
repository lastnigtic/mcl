package com.mcl.dao;

import com.mcl.pojo.UserCompanyCredit;

public interface UserCompanyCreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCompanyCredit record);

    int insertSelective(UserCompanyCredit record);

    UserCompanyCredit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCompanyCredit record);

    int updateByPrimaryKey(UserCompanyCredit record);
}