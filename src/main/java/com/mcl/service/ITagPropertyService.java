package com.mcl.service;

import com.mcl.common.ServerResponse;

import java.util.List;

/**
 * Created by Administrator on 2018/1/27 0027.
 */

public interface ITagPropertyService {
    List<String> getEduPropertyList();

    List<String> getCityPropertyList();

    List<String> getJobTageList();

    List<String> getJobTypeList();

    List<String> getFinancingsList();

    List<String> getIndustryList();

    List<String> getCompSizeList();

    List<String> getTagPropertiesByType(String type);

    ServerResponse getTagPropertiesByType(int pageNum, int pageSize, String type);

    ServerResponse getTagType();
}
