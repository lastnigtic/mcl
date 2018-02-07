package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.dao.*;
import com.mcl.pojo.*;
import com.mcl.service.IAdminService;
import com.mcl.service.IJobOffersServcie;
import com.mcl.util.MD5Util;
import com.mcl.util.MsgTemplate;
import com.mcl.vo.JobOffersVO;
import com.mcl.vo.StatisticsVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private OpinionMapper opinionMapper ;

    @Autowired
    private CompanyMsgMapper companyMsgMapper ;

    @Autowired
    private IJobOffersServcie iJobOffersServcie ;

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
    @Transactional
    public ServerResponse passCompany(String companyid, Integer checked) {
        Company company = companyMapper.selectByPrimaryKey(companyid);
        if(company!=null){
            //存在
            if(company.getChecked()==checked){
                return ServerResponse.createByErrorMessage("已经是此状态");
            }else {
                company.setChecked(checked);
                int rowCount = companyMapper.updateByPrimaryKey(company);

                /**
                 * 发送消息
                 */
                if(checked== Const.CompStatus.SuccessTOPass){
                    companyMsgMapper.insert(MsgTemplate.newCompanyPassMsg(company));
                }else if (checked==Const.CompStatus.FailTOPass){
                    companyMsgMapper.insert(MsgTemplate.newCompanyRejectMsg(company));
                }

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

                /**
                 * 发送消息
                 */
                if(checked== Const.CompStatus.SuccessTOPass){
                    companyMsgMapper.insert(MsgTemplate.newJobPassMsg(jobOffers));
                }else if (checked==Const.CompStatus.FailTOPass){
                    companyMsgMapper.insert(MsgTemplate.newJobRejectMsg(jobOffers));
                }
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

    /**
     * 获取意见列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Opinion> getOpinionList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        List<Opinion> list = opinionMapper.selectList();
        return list;
    }

    /**
     * 根据id查询企业的信息
     * @param id
     * @return
     */
    @Override
    public ServerResponse getCompInfoById(String id) {

        if(StringUtils.isBlank(id)){
            return ServerResponse.createByErrorMessage("参数为空");
        }
        Company company = companyMapper.selectByPrimaryKey(id);
        if(company!=null){
            return ServerResponse.createBySuccess(company);
        }
        return ServerResponse.createByErrorMessage("查询错误");

    }

    @Override
    public ServerResponse getJobById(Integer id) {
        if(id==null)
            return ServerResponse.createByErrorMessage("参数错误");
        JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(id);
        if(jobOffers!=null){
            JobOffersVO vo = iJobOffersServcie.getJobOffersVOFromJobOffers(jobOffers);
            return ServerResponse.createBySuccess(vo);
        }else {
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }
}
