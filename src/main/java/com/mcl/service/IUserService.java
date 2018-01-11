package com.mcl.service;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.Opinion;
import com.mcl.pojo.UserBaseInfo;

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
}
