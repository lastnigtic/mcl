package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.JobOffers;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
public interface IJobOffersServcie {
    ServerResponse addJob(JobOffers jobOffers);

    ServerResponse updateJob(JobOffers jobOffers);

    ServerResponse delJob(Integer id, String companyid);

    ServerResponse list(int pageNum, int pageSize, Account account, JobOffers jobOffers);

    ServerResponse getJob(Integer id, String companyid);
}
