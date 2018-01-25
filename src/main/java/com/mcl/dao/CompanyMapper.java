package com.mcl.dao;

import com.mcl.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> selectList(Company company);

    Integer count();

    int updateCredit(@Param("id") String id,@Param("credit") Double avgCredit);
}