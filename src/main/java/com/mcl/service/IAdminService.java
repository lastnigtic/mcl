package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Admin;
import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.UserBaseInfo;

/**
 * Created by Administrator on 2018/1/18 0018.
 */
public interface IAdminService {

    ServerResponse<Admin> login(String id, String pass);

    ServerResponse getCompanyList(int pageNum, int pageSize, Company company);


    ServerResponse getUserList(int pageNum, int pageSize, UserBaseInfo userBaseInfo);

    ServerResponse getJobList(int pageNum, int pageSize, JobOffers jobOffers);

    ServerResponse passCompany(String companyid, Integer checked);

    ServerResponse passJob(Integer id, Integer checked);

    ServerResponse getStatistics();


}
