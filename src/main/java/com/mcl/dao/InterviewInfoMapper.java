package com.mcl.dao;

import com.mcl.pojo.InterviewInfo;

public interface InterviewInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterviewInfo record);

    int insertSelective(InterviewInfo record);

    InterviewInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterviewInfo record);

    int updateByPrimaryKeyWithBLOBs(InterviewInfo record);

    int updateByPrimaryKey(InterviewInfo record);
}