package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.TagProperty;

import java.util.List;

/**
 * Created by Administrator on 2018/1/27 0027.
 */

public interface ITagPropertyService {
    List<String> getEduPropertyList();

    List<String> getCityPropertyList();

    List<String> getJobTageList();

    List<String> getJobTypeList();

    List<TagProperty> getJobTag();

    List<String> getFinancingsList();

    List<String> getIndustryList();

    List<String> getCompSizeList();

    List<String> getTagPropertiesByType(String type);

    ServerResponse getTagPropertiesByType(int pageNum, int pageSize, String type);

    ServerResponse getTagType();

    ServerResponse delTag(Integer id);

    ServerResponse addTag(TagProperty tag);

    ServerResponse updateTag(TagProperty tag);

    void updateTagList(List<TagProperty> tagPropertyList);

    ServerResponse customize();
}
