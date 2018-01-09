package com.mcl.dao;

import com.mcl.pojo.JobOffers;

public interface JobOffersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobOffers record);

    int insertSelective(JobOffers record);

    JobOffers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobOffers record);

    int updateByPrimaryKeyWithBLOBs(JobOffers record);

    int updateByPrimaryKey(JobOffers record);
}