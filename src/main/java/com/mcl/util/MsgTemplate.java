package com.mcl.util;

import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yz on 2018/1/31.
 */
public class MsgTemplate {

    public interface MsgType{
        String JobDeliveryMsg = "岗位投递消息";
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
