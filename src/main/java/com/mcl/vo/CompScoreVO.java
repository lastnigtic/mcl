package com.mcl.vo;

import com.mcl.pojo.Company;
import com.mcl.pojo.CompanyScore;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.UserBaseInfo;

/**
 * Created by yz on 2018/2/7.
 */
public class CompScoreVO {
    private CompanyScore companyScore ;

    private JobOffersVO jobOffersVO ;

    private UserBaseInfo userBaseInfo;

    public CompanyScore getCompanyScore() {
        return companyScore;
    }

    public UserBaseInfo getUserBaseInfo() {
        return userBaseInfo;
    }

    public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }

    public void setCompanyScore(CompanyScore companyScore) {
        this.companyScore = companyScore;
    }

    public JobOffersVO getJobOffersVO() {
        return jobOffersVO;
    }

    public void setJobOffersVO(JobOffersVO jobOffersVO) {
        this.jobOffersVO = jobOffersVO;
    }
}
