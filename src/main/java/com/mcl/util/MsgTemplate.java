package com.mcl.util;

import com.mcl.pojo.Company;
import com.mcl.pojo.CompanyMsg;
import com.mcl.pojo.JobOffers;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yz on 2018/1/31.
 */
public class MsgTemplate {

    /**
     * 企业通过验证的消息模版
     * @return
     * @param company
     */
    public static CompanyMsg newCompanyPassMsg(Company company) {
        CompanyMsg companyMsg = new CompanyMsg();
        companyMsg.setCompanyid(company.getId());
        companyMsg.setContent("恭喜您！已通过实名认证！");
        companyMsg.setTitle("通过实名认证");
        companyMsg.setStatus(0);
        companyMsg.setType(MsgType.SysMsg);
        return  companyMsg ;
    }

    /**
     * 企业实名认证被拒绝
     * @param company
     * @return
     */
    public static CompanyMsg newCompanyRejectMsg(Company company) {
        CompanyMsg companyMsg = new CompanyMsg();
        companyMsg.setCompanyid(company.getId());
        companyMsg.setContent("很遗憾！您的认证已被退回！请您更改资料上传！");
        companyMsg.setTitle("实名认证退回");
        companyMsg.setStatus(0);
        companyMsg.setType(MsgType.SysMsg);
        return  companyMsg ;
    }

    /**
     * 岗位审核通过
     * @param jobOffers
     * @return
     */
    public static CompanyMsg newJobPassMsg(JobOffers jobOffers) {
        CompanyMsg companyMsg = new CompanyMsg();
        companyMsg.setCompanyid(jobOffers.getCompanyid());
        companyMsg.setContent("恭喜您！！您的"+jobOffers.getJobname()+"岗位已被审核通过！");
        companyMsg.setTitle("岗位审核通过");
        companyMsg.setStatus(0);
        companyMsg.setType(MsgType.SysMsg);
        return  companyMsg ;
    }

    /**
     * 岗位审核不通过
     * @param jobOffers
     * @return
     */
    public static CompanyMsg newJobRejectMsg(JobOffers jobOffers) {
        CompanyMsg companyMsg = new CompanyMsg();
        companyMsg.setCompanyid(jobOffers.getCompanyid());
        companyMsg.setContent("很遗憾！！您的"+jobOffers.getJobname()+"岗位已被退回！");
        companyMsg.setTitle("岗位审核不通过");
        companyMsg.setStatus(0);
        companyMsg.setType(MsgType.SysMsg);
        return  companyMsg ;
    }

    public interface MsgType{
        String JobDeliveryMsg = "岗位投递消息";
        int SysMsg = 1 ;
    }

    public static String interviewMsg(Company company, JobOffers jobOffers){
        if(company==null|| StringUtils.isBlank(company.getCompanyname())||jobOffers==null||StringUtils.isBlank(jobOffers.getJobname()))
            return "您收到一条新的邀约面试信息";
        return "您收到一条【"+company.getCompanyname()+"】公司的【"+jobOffers.getJobname()+"】岗位邀约面试";
    }

    public static String passInterviewMsg(JobOffers jobOffers){
        if(jobOffers==null||StringUtils.isBlank(jobOffers.getJobname()))
            return "您有岗位面试通过的消息";
        return "您的【"+jobOffers.getJobname()+"】岗位面试已通过";
    }

    public static String failInterviewMsg(JobOffers jobOffers){
        if(jobOffers==null||StringUtils.isBlank(jobOffers.getJobname()))
            return "您有岗位面试不合适的消息";
        return "您的【"+jobOffers.getJobname()+"】岗位面试不合适";
    }

    public static String alreadyViewedMsg(JobOffers jobOffers){
        if(jobOffers==null||StringUtils.isBlank(jobOffers.getJobname()))
            return "您有岗位简历被查看的消息";
        return "您投递的【"+jobOffers.getJobname()+"】岗位，简历已被查看";
    }
}
