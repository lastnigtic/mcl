package com.mcl.dao;

import com.mcl.pojo.JobOffers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobOffersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobOffers record);

    int insertSelective(JobOffers record);

    JobOffers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobOffers record);

    int updateByPrimaryKeyWithBLOBs(JobOffers record);

    int updateByPrimaryKey(JobOffers record);

    int checkOffersByJoid(@Param("id") Integer joid);  //查看是否存在该条记录

    List<JobOffers> selectUserDeliveredJobOffersList(String openid);

    List<JobOffers> selectUserDeliveredJobOffersListByStatus(@Param("openid") String openid, @Param("status") Integer status);

    List<JobOffers> selectList(JobOffers record);

    List<JobOffers> recommendList();

    List<JobOffers> myJobList(JobOffers jobOffers);

    Integer count();

}