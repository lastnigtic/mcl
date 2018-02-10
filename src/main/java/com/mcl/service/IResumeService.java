package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.Resume;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public interface IResumeService {
    ServerResponse saveOrUpdateResume(Resume resume);

    ServerResponse delResume(String openid, Integer id);

    ServerResponse detail(Integer id);

    ServerResponse getResumeBox(int pageNum, int pageSize, Resume resume, Account account);

    ServerResponse getResumeFromBox(Integer id,Integer resumeid, String companyid);

    ServerResponse changeResumeStatus(Integer id, Integer joid, String companyid, Integer status, String msg, Date entrytime);

    ServerResponse getResumeByJobId(int pageNum, int pageSize, Integer id, String companyid);

    ServerResponse getResumeVOByRdsIdAndResId(Integer id, Integer resumeid);

    ServerResponse saveResumeImgPath(Integer resumeid, String imgpath, HttpServletRequest request);
}
