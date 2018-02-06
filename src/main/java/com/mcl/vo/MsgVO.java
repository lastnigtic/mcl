package com.mcl.vo;

import com.mcl.pojo.Company;
import com.mcl.pojo.CompanyMsg;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.UserMsg;

/**
 * Created by Administrator on 2018/2/5 0005.
 */
public class MsgVO {
    private UserMsg userMsg ;

    private CompanyMsg companyMsg ;

    private Company company ;

    private JobOffersVO job ;

    public UserMsg getUserMsg() {
        return userMsg;
    }

    public void setUserMsg(UserMsg userMsg) {
        this.userMsg = userMsg;
    }

    public CompanyMsg getCompanyMsg() {
        return companyMsg;
    }

    public void setCompanyMsg(CompanyMsg companyMsg) {
        this.companyMsg = companyMsg;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JobOffersVO getJob() {
        return job;
    }

    public void setJob(JobOffersVO job) {
        this.job = job;
    }
}
