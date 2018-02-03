package com.mcl.dao;

import com.mcl.pojo.CompanyMsg;

import java.util.List;

public interface CompanyMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyMsg record);

    int insertSelective(CompanyMsg record);

    CompanyMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyMsg record);

    int updateByPrimaryKey(CompanyMsg record);

    List<CompanyMsg> selectList(CompanyMsg companyMsg);

    int readMsg(Integer id);
}