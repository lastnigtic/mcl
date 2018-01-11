package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Resume;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public interface IResumeService {
    ServerResponse saveOrUpdateResume(Resume resume);

    ServerResponse delResume(Integer id);
}
