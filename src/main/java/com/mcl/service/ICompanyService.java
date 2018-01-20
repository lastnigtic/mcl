package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Company;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public interface ICompanyService {

    ServerResponse getCompanyDetail(String id);

    void updateCompany(Company company);


}
