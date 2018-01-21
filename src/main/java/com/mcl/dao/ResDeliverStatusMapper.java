package com.mcl.dao;

import com.mcl.pojo.ResDeliverStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResDeliverStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResDeliverStatus record);

    int insertSelective(ResDeliverStatus record);

    ResDeliverStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResDeliverStatus record);

    int updateByPrimaryKey(ResDeliverStatus record);

    int checkUserDelivered(@Param("openid") String openid,@Param("joid") Integer joid);

    int viewedByResumeId(Integer id);

    ResDeliverStatus selectByResumeId(Integer id);

    Integer count();

    List<ResDeliverStatus> getResumeStatusBox(@Param("companyid") String companyid);
}