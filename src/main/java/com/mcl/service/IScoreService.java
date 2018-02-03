package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.CompanyScore;
import com.mcl.pojo.UserScore;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/2/3 0003.
 */
public interface IScoreService {
    ServerResponse getUserAvgAbility(@Param("openid") String openid);

    ServerResponse getCompAvgAbility(String companyid);

    ServerResponse getCompRateList(int pageNum, int pageSize, String companyid, CompanyScore companyScore);

    ServerResponse getUserRateList(int pageNum, int pageSize, UserScore userScore);
}
