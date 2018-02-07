package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.dao.CompanyMapper;
import com.mcl.dao.CompanyScoreMapper;
import com.mcl.dao.JobOffersMapper;
import com.mcl.pojo.Account;
import com.mcl.pojo.CompAvgAbility;
import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import com.mcl.service.IJobOffersServcie;
import com.mcl.vo.JobOffersVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
@Service("iJobOffersServcie")
public class IJobOffersServcieImpl implements IJobOffersServcie {
    @Autowired
    private JobOffersMapper jobOffersMapper ;

    @Autowired
    private CompanyMapper companyMapper ;

    @Autowired
    private CompanyScoreMapper companyScoreMapper ;

    /**
     * 发布招聘信息
     * @param jobOffers
     * @return
     */
    @Override
    public ServerResponse addJob(JobOffers jobOffers) {
        if(jobOffers==null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        if(checkJobInfoComplete(jobOffers)){
            //信息完整
            jobOffers.setChecked(0); //设置待审核
            int row = jobOffersMapper.insert(jobOffers);
            if(row>0){
                return ServerResponse.createBySuccess("发布成功！待审核！",jobOffers);
            }
            return ServerResponse.createByErrorMessage("发布失败");
        }
        return ServerResponse.createByErrorMessage("信息不完整");
    }


    /**
     * 修改招聘信息
     * @param jobOffers
     * @return
     */
    @Override
    public ServerResponse updateJob(JobOffers jobOffers) {

        //判空
        if(jobOffers==null||StringUtils.isBlank(jobOffers.getCompanyid()))
            return ServerResponse.createByErrorMessage("参数错误");


        if(jobOffers.getId()!=null){
            JobOffers job = jobOffersMapper.selectByPrimaryKey(jobOffers.getId());

            if(job==null)
                return ServerResponse.createByErrorMessage("更新错误");

            if(job.getChecked()==Const.JobStatus.SuccessTOPass)
                return ServerResponse.createByErrorMessage("已通过审核的岗位修改权限受限");//有待商榷

            if(checkJobInfoComplete(jobOffers)){
                //信息完整，可以更新
                if(job.getChecked()==Const.JobStatus.FailTOPass)
                    job.setChecked(Const.JobStatus.NoApproval);//未通过的，修改之后，变为未审核，重新提交

                int rowUpdate = jobOffersMapper.updateByPrimaryKeySelective(jobOffers);
                if(rowUpdate>0){
                    return ServerResponse.createBySuccess("修改成功",jobOffers);
                }
                return ServerResponse.createByErrorMessage("修改失败！");
            }
            return ServerResponse.createByErrorMessage("传入参数错误！");
        }
        return ServerResponse.createByErrorMessage("传入参数错误！");
    }


    /**
     * 删除发布的招聘信息  将岗位设置为过期，而不是真正的删除
     * @param id 岗位id
     * @param companyid 企业的id
     * @return
     */
    @Override
    public ServerResponse delJob(Integer id, String companyid) {

        //判断空参
        if(id==null||StringUtils.isBlank(companyid))
            return ServerResponse.createByErrorMessage("传入参数为空");

        //判断企业是否有权限
        int haveAuthentication = companyMapper.haveAuthentication(companyid,Const.CompStatus.SuccessTOPass);

        if(haveAuthentication==0)
            return ServerResponse.createByErrorMessage("无权操作");

        //判断是否存在该记录
        int row = jobOffersMapper.checkOffersByJoid(id);

        if(row>0){
            //存在
            JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(id);
            if(!jobOffers.getCompanyid().equals(companyid))
                return ServerResponse.createByErrorMessage("这不是你发布的信息，无法删除");
            jobOffers.setChecked(Const.JobStatus.Overdue);  //将岗位设置为过期，而不是真正的删除

            int rowDel = jobOffersMapper.updateByPrimaryKeySelective(jobOffers);

            if(rowDel>0){
                return ServerResponse.createBySuccess("删除成功");
            }
            return ServerResponse.createByErrorMessage("删除错误！");
        }
        return ServerResponse.createByErrorMessage("找不到该招聘信息");
    }

    /**
     * 获取我发布的招聘列表
     * @param pageNum
     * @param pageSize
     * @param account
     * @param jobOffers
     * @return
     */
    @Override
    public ServerResponse<PageInfo> list(int pageNum, int pageSize, Account account, JobOffers jobOffers) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        jobOffers.setCompanyid(account.getCompanyid());
        List<JobOffers> list = jobOffersMapper.myJobList(jobOffers);
        List<JobOffersVO> rtnlist = new ArrayList<>();
        PageInfo pageResult = new PageInfo(list);
        for(JobOffers jo:list){
            JobOffersVO vo = getJobOffersVOFromJobOffers(jo);
            rtnlist.add(vo);
        }
        pageResult.setList(rtnlist);
        return ServerResponse.createBySuccess(pageResult);
    }


    /**
     * 获取招聘信息详情
     * @param id
     * @param companyid
     * @return
     */
    @Override
    public ServerResponse getJob(Integer id, String companyid) {
        JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(id);
        if(jobOffers==null)return ServerResponse.createByErrorMessage("获取失败");
        if(!jobOffers.getCompanyid().equals(companyid))return ServerResponse.createByErrorMessage("错误！没有权限");
        return ServerResponse.createBySuccess("获取成功",getJobOffersVOFromJobOffers(jobOffers));
    }

    /**
     * 填写的信息是否完整
     * @return
     */
    private boolean checkJobInfoComplete(JobOffers jobOffers) {
        if(jobOffers==null)return false;
        if(StringUtils.isBlank(jobOffers.getJobname()))return false ;
        if(StringUtils.isBlank(jobOffers.getCity()))return false;
        if(StringUtils.isBlank(jobOffers.getAddress()))return false;
        if(StringUtils.isBlank(jobOffers.getType()))return false;
        if (StringUtils.isBlank(jobOffers.getDescription()))return false;
        if(jobOffers.getWage()==null)return false;
        if(jobOffers.getWorkfrequency()==null)return false;
        if(jobOffers.getDuration()==null)return false;
        return true;
    }

    /**
     * 获取招聘信息列表
     * @param pageNum
     * @param pageSize
     * @param jobOffers
     * @param keywords
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getOfferList(int pageNum, int pageSize, JobOffers jobOffers, String keywords) {
        PageHelper.startPage(pageNum,pageSize);
        //看看keywords有没有
        PageHelper.orderBy("updatetime desc");
        //有keywords
        if(jobOffers==null) {
            jobOffers = new JobOffers();
        }
        jobOffers.setChecked(1); //必须要审核过的才可以
        if(StringUtils.isNotBlank(keywords)){
            String k = new StringBuilder().append("%").append(keywords).append("%").toString();
            jobOffers.setJobname(k);
        }
        List<JobOffers> jobOffersList = jobOffersMapper.selectList(jobOffers);
        List<JobOffersVO> list = Lists.newArrayList();
        for(JobOffers jo:jobOffersList){
            JobOffersVO vo = getJobOffersVOFromJobOffers(jo);
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
                JobOffersVO v = getJobOffersVOFromJobOffers(jo);
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
     * @param job
     * @return
     */
    @Override
    public ServerResponse<PageInfo> recommendList(int pageNum, int pageSize, JobOffers job) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("wage desc");

        if(job!=null&&StringUtils.isNotBlank(job.getTag())){
            String str = job.getTag() ;
            str = new StringBuilder().append("%").append(str).append("%").toString();
            job.setTag(str);
        }
        List<JobOffers> jobOffersList = jobOffersMapper.recommendList(job);
        List<JobOffersVO> list = Lists.newArrayList();
        for(JobOffers jo:jobOffersList){
            JobOffersVO vo = getJobOffersVOFromJobOffers(jo);
            list.add(vo);
        }
        PageInfo pageResult = new PageInfo(jobOffersList);
        //将封装好的volist放进去
        pageResult.setList(list);
        return ServerResponse.createBySuccess(pageResult);
    }


    /**
     * 将joboffers转为jobvo
     * @param jobOffers
     * @return
     */
    public JobOffersVO getJobOffersVOFromJobOffers(JobOffers jobOffers){
        JobOffersVO vo = new JobOffersVO();
        vo.setAddress(jobOffers.getAddress());
        vo.setChecked(jobOffers.getChecked());
        vo.setCity(jobOffers.getCity());
        vo.setDescription(jobOffers.getDescription());
        vo.setDuration(jobOffers.getDuration());
        vo.setEducation(jobOffers.getEducation());
        vo.setId(jobOffers.getId());
        vo.setJobname(jobOffers.getJobname());
        vo.setWage(jobOffers.getWage());
        vo.setType(jobOffers.getType());
        vo.setWorkfrequency(jobOffers.getWorkfrequency());
        vo.setUpdatetime(jobOffers.getUpdatetime());
        vo.setRequirements(jobOffers.getRequirements());
        String tag = jobOffers.getTag();
        String[] tags = StringUtils.isBlank(tag)?null:tag.split(",");
        vo.setTag(tags);
        vo.setTemptation(jobOffers.getTemptation());
        if(StringUtils.isNotBlank(jobOffers.getCompanyid())){
            vo.setCompanyid(jobOffers.getCompanyid());
            Company company = companyMapper.selectByPrimaryKey(jobOffers.getCompanyid());
            CompAvgAbility compAvgAbility = companyScoreMapper.getCompAvgAbitlity(jobOffers.getCompanyid());
            if(company!=null)
                vo.setCompany(company);
            if(compAvgAbility!=null)
                vo.setCompAvgAbility(compAvgAbility);
        }
        return vo;
    }
}
