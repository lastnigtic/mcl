package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.dao.TagPropertyMapper;
import com.mcl.service.ITagPropertyService;
import org.apache.commons.lang3.StringUtils;
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

    /**
     * 根据type获取
     * @param type
     * @return
     */
    @Override
    public List<String> getTagPropertiesByType(String type) {
        return tagPropertyMapper.selectListByType(type);
    }

    @Override
    public ServerResponse getTagPropertiesByType(int pageNum, int pageSize, String type) {

        if(StringUtils.isBlank(type))
            return ServerResponse.createByErrorMessage("参数为空");

        PageHelper.startPage(pageNum,pageSize);

        List<String> list = tagPropertyMapper.selectListByType(type);

        PageInfo pageInfo = new PageInfo(list);

        return  ServerResponse.createBySuccess(pageInfo);

    }

    /**
     * 获取所有类型的属性名称
     * @return
     */
    @Override
    public ServerResponse getTagType() {
        return ServerResponse.createBySuccess(tagPropertyMapper.getTagType());
    }
}
