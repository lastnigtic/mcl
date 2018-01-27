package com.mcl.service.impl;

import com.mcl.dao.TagPropertyMapper;
import com.mcl.service.ITagPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/27 0027.
 */
@Service("iTagPropertyService")
public class ITagPropertyServiceImpl implements ITagPropertyService {

    @Autowired
    private TagPropertyMapper tagPropertyMapper;

    @Override
    public List<String> getEduPropertyList() {
        return tagPropertyMapper.selectListByType("edu");
    }

    @Override
    public List<String> getCityPropertyList() {
        return tagPropertyMapper.selectListByType("city");
    }

    @Override
    public List<String> getJobTageList() {
        return tagPropertyMapper.selectListByType("jobtag");
    }

    @Override
    public List<String> getJobTypeList() {
        return tagPropertyMapper.selectListByType("jobtype");
    }

    @Override
    public List<String> getFinancingsList() {
        return tagPropertyMapper.selectListByType("financings");
    }

    @Override
    public List<String> getIndustryList() {
        return tagPropertyMapper.selectListByType("industry");
    }

    @Override
    public List<String> getCompSizeList() {
        return tagPropertyMapper.selectListByType("compsize");
    }
}
