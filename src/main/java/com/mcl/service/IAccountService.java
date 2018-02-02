package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.Company;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
public interface IAccountService {
    ServerResponse<Account> login(String uname, String upass);

    ServerResponse<String> register(Account account);

    ServerResponse saveOrUpdateCompany(Integer id, Company company);

    Company getCompanyByAccount(Integer id);

    ServerResponse isPassVerified(Integer id);

    ServerResponse rateToUser(String openid, String companyid, Double credit);

    boolean isCompanyHaveAuthorityScoreUser(String openid, String companyid);
}
