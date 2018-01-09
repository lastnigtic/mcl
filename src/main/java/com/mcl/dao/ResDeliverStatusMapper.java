package com.mcl.dao;

import com.mcl.pojo.ResDeliverStatus;

public interface ResDeliverStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResDeliverStatus record);

    int insertSelective(ResDeliverStatus record);

    ResDeliverStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResDeliverStatus record);

    int updateByPrimaryKeyWithBLOBs(ResDeliverStatus record);

    int updateByPrimaryKey(ResDeliverStatus record);
}