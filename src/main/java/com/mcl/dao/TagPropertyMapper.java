package com.mcl.dao;

import com.mcl.pojo.TagProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagProperty record);

    int insertSelective(TagProperty record);

    TagProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagProperty record);

    int updateByPrimaryKey(TagProperty record);

    List<String> selectEduList();

    List<String>  selectListByType(String type);

    List<String>  getTagType();

    List<TagProperty> selectTagListByType(String type);

    void cleanAllOrder();

    List<TagProperty> get4Icon();

    List<TagProperty> getJobTag();
}