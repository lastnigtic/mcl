package com.mcl.dao;

import com.mcl.pojo.ResEdu;

public interface ResEduMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResEdu record);

    int insertSelective(ResEdu record);

    ResEdu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResEdu record);

    int updateByPrimaryKey(ResEdu record);
}