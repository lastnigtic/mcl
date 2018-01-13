package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mcl.common.ServerResponse;
import com.mcl.dao.CompanyMapper;
import com.mcl.dao.JobOffersMapper;
import com.mcl.dao.UserBaseInfoMapper;
import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import com.mcl.service.IOffersService;
import com.mcl.vo.JobOffersListVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Service("iOffersService")
public class IOffersServiceImpl implements IOffersService {

    @Autowired
    private JobOffersMapper jobOffersMapper;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 获取招聘信息列表
     * @param pageNum
     * @param pageSize
     * @param jobOffers
     * @param keywords
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getOfferList(int pageNum, int pageSize,JobOffers jobOffers, String keywords) {
        PageHelper.startPage(pageNum,pageSize);
        //看看keywords有没有
        if(StringUtils.isNotBlank(keywords)){
            //有keywords
            if(jobOffers==null) {
                jobOffers = new JobOffers();
            }
            String k = new StringBuilder().append("%").append(keywords).append("%").toString();
            jobOffers.setJobname(k);
        }
        List<JobOffers> jobOffersList = jobOffersMapper.selectList(jobOffers);
        List<JobOffersListVO> list = Lists.newArrayList();
        for(JobOffers jo:jobOffersList){
            JobOffersListVO vo = assembleJobOffersListVO(jo);
            list.add(vo);
        }
        PageInfo pageResult = new PageInfo(jobOffersList);
        //将封装好的volist放进去
        pageResult.setList(list);
        return ServerResponse.createBySuccess(pageResult);

    }

    /**
     * 查看具体的招聘信息
     * @param joid
     * @return
     */
    @Override
    public ServerResponse getOfferDetail(Integer joid) {
        if (joid!=null){
            JobOffers jo = jobOffersMapper.selectByPrimaryKey(joid);
            if (jo != null) {
                JobOffersListVO v = assembleJobOffersListVO(jo);
                return ServerResponse.createBySuccess(v);
            }
            return ServerResponse.createByErrorMessage("找不到该招聘信息！");
        }
        return ServerResponse.createByErrorMessage("传入参数有误！");
    }


    /**
     * 获取推荐招聘信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> recommendList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("wage desc");
        List<JobOffers> jobOffersList = jobOffersMapper.recommendList();
        List<JobOffersListVO> list = Lists.newArrayList();
        for(JobOffers jo:jobOffersList){
            JobOffersListVO vo = assembleJobOffersListVO(jo);
            list.add(vo);
        }
        PageInfo pageResult = new PageInfo(jobOffersList);
        //将封装好的volist放进去
        pageResult.setList(list);
        return ServerResponse.createBySuccess(pageResult);
    }


    private JobOffersListVO assembleJobOffersListVO(JobOffers jobOffers){
        JobOffersListVO vo = new JobOffersListVO();
        vo.setAddress(jobOffers.getAddress());
        vo.setCheckd(jobOffers.getChecked());
        vo.setCity(jobOffers.getCity());
        vo.setDescription(jobOffers.getDescription());
        vo.setDuration(jobOffers.getDuration());
        vo.setEducation(jobOffers.getEducation());
        vo.setId(jobOffers.getId());
        vo.setJobname(jobOffers.getJobname());
        vo.setWage(jobOffers.getWage());
        vo.setType(jobOffers.getType());
        vo.setWorkfrequency(jobOffers.getWorkfrequency());
        vo.setTag(jobOffers.getTag());
        vo.setUpdatetime(jobOffers.getUpdatetime());
        String[] temptations = jobOffers.getTemptation().split(",");
        vo.setTemptation(temptations);
        if(jobOffers.getCompanyid()!=null){
            vo.setCompanyid(jobOffers.getCompanyid());
            Company company = companyMapper.selectByPrimaryKey(jobOffers.getCompanyid());
            if(company!=null){
                vo.setCompany(company);
            }
        }
        return vo;
    }
}
