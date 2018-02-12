package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.Company;
import com.mcl.pojo.UserScore;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
public interface IAccountService {
    ServerResponse<Account> login(String uname, String upass);

    ServerResponse<String> register(Account account);

    ServerResponse saveOrUpdateCompany(Integer id, Company company, HttpSession session);

    Company getCompanyByAccount(Integer id);

    ServerResponse isPassVerified(Integer id);

    ServerResponse rateToUser(UserScore userScore);

    boolean isCompanyHaveAuthorityScoreUser(String openid, String companyid,Integer joid);



}
