package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.dao.TagPropertyMapper;
import com.mcl.pojo.TagProperty;
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


    @Override
    public ServerResponse delTag(Integer id) {
        int row = tagPropertyMapper.deleteByPrimaryKey(id);
        if(row>0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }


    public ServerResponse addTag(TagProperty tag){
        if(tag==null||StringUtils.isBlank(tag.getName())||StringUtils.isBlank(tag.getType()))
            return ServerResponse.createByErrorMessage("参数为空");

        int row = tagPropertyMapper.insert(tag);

        if(row>0){
            return ServerResponse.createBySuccess(tag);
        }
        return ServerResponse.createByErrorMessage("新增失败");
    }

    /**
     * 修改标签
     * @param tag
     * @return
     */
    @Override
    public ServerResponse updateTag(TagProperty tag) {
        if(tag==null||tag.getId()==null||StringUtils.isBlank(tag.getName())||StringUtils.isBlank(tag.getType()))
            return ServerResponse.createByErrorMessage("参数为空");

        int row = tagPropertyMapper.updateByPrimaryKey(tag);

        if(row>0){
            return ServerResponse.createBySuccess(tag);
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }
}
