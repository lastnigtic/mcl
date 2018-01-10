package com.mcl.dao;

import com.mcl.pojo.JobOffers;
import com.mcl.pojo.UserCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    UserCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);

    int countUserCollectByOpenid(String openid); //查看用户收藏数

    List<JobOffers> selectUserCollectedJobOffersList(String openid); //查看用户收藏的招聘信息列表

    int countUserCollectByOpenidJoid(@Param("openid") String openid,@Param("joid") Integer joid); //查看用户是否收藏

    int deleteByOpenidJoid(@Param("openid") String openid,@Param("joid") Integer joid);
}