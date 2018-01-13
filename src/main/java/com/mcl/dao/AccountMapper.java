package com.mcl.dao;

import com.mcl.pojo.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    int checkUame(String uname);

    Account selectLogin(@Param("uname") String uname,@Param("upass") String md5Password);

    String selectCompanyIdById(Integer id);
}