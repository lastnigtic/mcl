package com.mcl.dao;

import com.mcl.pojo.ResDeliverStatus;
import org.apache.ibatis.annotations.Param;

public interface ResDeliverStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResDeliverStatus record);

    int insertSelective(ResDeliverStatus record);

    ResDeliverStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResDeliverStatus record);

    int updateByPrimaryKeyWithBLOBs(ResDeliverStatus record);

    int updateByPrimaryKey(ResDeliverStatus record);

    int checkUserDelivered(@Param("openid") String openid,@Param("joid") Integer joid);
}