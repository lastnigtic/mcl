package com.mcl.service;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.JobOffers;
import com.mcl.vo.JobOffersVO;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
public interface IJobOffersServcie {
    ServerResponse addJob(JobOffers jobOffers);

    ServerResponse updateJob(JobOffers jobOffers);

    ServerResponse delJob(Integer id, String companyid);

    ServerResponse list(int pageNum, int pageSize, Account account, JobOffers jobOffers);

    ServerResponse getJob(Integer id, String companyid);


    ServerResponse<PageInfo> getOfferList(int pageNum, int pageSize, JobOffers jobOffers, String keywords);

    ServerResponse getOfferDetail(Integer joid);

    ServerResponse<PageInfo> recommendList(int pageNum, int pageSize);

    JobOffersVO getJobOffersVOFromJobOffers(JobOffers jobOffers);
}
