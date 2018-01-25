package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.dao.*;
import com.mcl.pojo.Admin;
import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.UserBaseInfo;
import com.mcl.service.IAdminService;
import com.mcl.util.MD5Util;
import com.mcl.vo.StatisticsVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/18 0018.
 */
@Service(value = "iAdminService")
public class IAdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper ;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

    @Autowired
    private JobOffersMapper jobOffersMapper ;

    @Autowired
    private ResDeliverStatusMapper resDeliverStatusMapper;
    /**
     * 管理员登录
     * @param id
     * @param pass
     * @return
     */
    @Override
    public ServerResponse<Admin> login(String id, String pass) {
        int resultCount = adminMapper.checkId(id);
        if(resultCount == 0 ){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String md5Password = MD5Util.MD5EncodeUtf8(pass);
        Admin admin  = adminMapper.selectLogin(id,md5Password);
        if(admin == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        admin.setPass(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",admin);
    }

    /**
     * 获取公司列表
     * @return
     * @param pageNum
     * @param pageSize
     * @param company
     */
    @Override
    public ServerResponse getCompanyList(int pageNum, int pageSize, Company company) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        if(company!=null&& StringUtils.isNotBlank(company.getIntroduction())){
            String str = company.getIntroduction();
            str = new StringBuilder().append("%").append(str).append("%").toString();
            company.setIntroduction(str);
        }
        List<Company> ls = companyMapper.selectList(company);
        PageInfo pageResult = new PageInfo(ls);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 获取用户列表
     * @param pageNum
     * @param pageSize
     * @param userBaseInfo
     * @return
     */
    @Override
    public ServerResponse getUserList(int pageNum, int pageSize, UserBaseInfo userBaseInfo) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        if(userBaseInfo!=null&& StringUtils.isNotBlank(userBaseInfo.getRealname())){
            String str = userBaseInfo.getRealname();
            str = new StringBuilder().append("%").append(str).append("%").toString();
            userBaseInfo.setRealname(str);
        }
        List<UserBaseInfo> list = userBaseInfoMapper.selectList(userBaseInfo);
        PageInfo pageResult = new PageInfo(list);
        return ServerResponse.createBySuccess(pageResult);
    }


    /**
     * 获取岗位列表
     * @param pageNum
     * @param pageSize
     * @param jobOffers
     * @return
     */
    @Override
    public ServerResponse getJobList(int pageNum, int pageSize, JobOffers jobOffers) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        if(jobOffers!=null&& StringUtils.isNotBlank(jobOffers.getJobname())){
            String str = jobOffers.getJobname();
            str = new StringBuilder().append("%").append(str).append("%").toString();
            jobOffers.setJobname(str);
        }
        List<JobOffers> list = jobOffersMapper.selectList(jobOffers);
        PageInfo pageResult = new PageInfo(list);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 更改公司的审核状态
     * @param companyid
     * @param checked
     * @return
     */
    @Override
    public ServerResponse passCompany(String companyid, Integer checked) {
        Company company = companyMapper.selectByPrimaryKey(companyid);
        if(company!=null){
            //存在
            if(company.getChecked()==checked){
                return ServerResponse.createByErrorMessage("已经是此状态");
            }else {
                company.setChecked(checked);
                int rowCount = companyMapper.updateByPrimaryKey(company);
                if (rowCount>0){
                    return ServerResponse.createBySuccess("修改成功");
                }
                return ServerResponse.createByErrorMessage("修改失败");
            }
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }


    /**
     * 审核岗位
     * @param id
     * @param checked
     * @return
     */
    @Override
    public ServerResponse passJob(Integer id, Integer checked) {
        JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(id);
        if(jobOffers!=null){
            //存在
            if(jobOffers.getChecked()==checked){
                return ServerResponse.createByErrorMessage("已经是此状态");
            }else {
                jobOffers.setChecked(checked);
                int rowCount = jobOffersMapper.updateByPrimaryKey(jobOffers);
                if (rowCount>0){
                    return ServerResponse.createBySuccess("修改成功");
                }
                return ServerResponse.createByErrorMessage("修改失败");
            }
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }

    /**
     * 获取统计数据
     * @return
     */
    @Override
    public ServerResponse getStatistics() {
        StatisticsVO vo = new StatisticsVO();
        vo.setCompanyamount(companyMapper.count());
        vo.setJobamount(jobOffersMapper.count());
        vo.setUseramount(userBaseInfoMapper.count());
        vo.setResumesubmitamount(resDeliverStatusMapper.count());
        return vo!=null?ServerResponse.createBySuccess(vo):ServerResponse.createByErrorMessage("获取数据错误");
    }
}