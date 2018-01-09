package com.mcl.dao;

import com.mcl.pojo.TagProperty;

public interface TagPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagProperty record);

    int insertSelective(TagProperty record);

    TagProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagProperty record);

    int updateByPrimaryKey(TagProperty record);
}