package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.Resume;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public interface IResumeService {
    ServerResponse saveOrUpdateResume(Resume resume);

    ServerResponse delResume(String openid, Integer id);

    ServerResponse detail(Integer id);

    ServerResponse getResumeBox(int pageNum, int pageSize, Resume resume, Account account);

    ServerResponse getResumeFromBox(Integer id, String companyid);

    ServerResponse changeResumeStatus(Integer id, String companyid, Integer status, String msg);
}
