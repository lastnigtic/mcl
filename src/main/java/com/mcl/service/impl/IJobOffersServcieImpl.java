package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.dao.JobOffersMapper;
import com.mcl.pojo.Account;
import com.mcl.pojo.JobOffers;
import com.mcl.service.IJobOffersServcie;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
@Service("iJobOffersServcie")
public class IJobOffersServcieImpl implements IJobOffersServcie {
    @Autowired
    private JobOffersMapper jobOffersMapper ;


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
        if(jobOffers==null)return ServerResponse.createByErrorMessage("参数错误");
        if(jobOffers.getId()!=null){
            int row = jobOffersMapper.checkOffersByJoid(jobOffers.getId());
            if(row>0&&checkJobInfoComplete(jobOffers)){
                //存在该信息
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
     * 删除发布的招聘信息
     * @param id
     * @param companyid
     * @return
     */
    @Override
    public ServerResponse delJob(Integer id, String companyid) {
        if(id==null)return ServerResponse.createByErrorMessage("传入参数错误");
        int row = jobOffersMapper.checkOffersByJoid(id);
        if(row>0){
            //存在
            JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(id);
            if(!jobOffers.getCompanyid().equals(companyid))
                return ServerResponse.createByErrorMessage("这不是你发布的信息，无法删除");
            int rowDel = jobOffersMapper.deleteByPrimaryKey(id);
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
        PageInfo pageResult = new PageInfo(list);
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
        return ServerResponse.createBySuccess("获取成功",jobOffers);
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
}
