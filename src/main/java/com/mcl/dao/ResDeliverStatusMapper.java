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

    List<Integer> getResumeIdListByJobId(@Param("id") Integer id);

    List<ResDeliverStatus> getResumeStatusListByJobId(@Param("id") Integer id);

    ResDeliverStatus isUserHaveAuthorityScoreCompany(@Param("openid") String openid, @Param("companyid") String companyid);

    ResDeliverStatus getStatusByJobIdAndReId(@Param("reid") Integer reid, @Param("joid") Integer joid);

    ResDeliverStatus getStatusById(@Param("id") Integer id);
}