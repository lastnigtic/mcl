package com.mcl.service;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.CompanyScore;
import com.mcl.pojo.Opinion;
import com.mcl.pojo.UserAvgAbility;
import com.mcl.pojo.UserBaseInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public interface IUserService {
    ServerResponse saveOrUpdateUser(UserBaseInfo userBaseInfo);

    ServerResponse getUserCollectJobCount(String openid);

    ServerResponse<PageInfo> getUserCollectJobList(String openid, int pageNum, int pageSize);

    ServerResponse checkJobIsCollect(String openid, Integer joid);

    ServerResponse checkJobIsDeliver(String openid, Integer joid);

    ServerResponse collectJob(String openid, Integer joid);

    ServerResponse uncollectJob(String openid, Integer joid);

    ServerResponse deliverResume(String openid, Integer joid, Integer reid);

    ServerResponse submitOpinion(Opinion opinion);

    ServerResponse getUserDeliveredList(String openid, int pageNum, int pageSize, Integer status);

    ServerResponse isUserFirstLogin(String openid);

    ServerResponse info(String openid);

    ServerResponse myResumeList(String openid);

    ServerResponse myMsg(String openid, int pageNum, int pageSize, Integer readstatus);

    ServerResponse msg(Integer id, String openid);

    ServerResponse delMsg(Integer id, String openid);

    boolean checkOpenid(String openid);

    ServerResponse rateToCompany(CompanyScore companyScore);

    boolean isUserHaveAuthorityScoreCompany(String openid, String companyid,Integer joid);

    ServerResponse readMsg(String openid, Integer id);
}
