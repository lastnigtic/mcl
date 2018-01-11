package com.mcl.vo;

import com.mcl.pojo.Company;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/10 0010.
 */
public class JobOffersListVO {
    private Integer id;

    private String jobname;

    private String[] temptation;

    private String tag;

    private String type;

    private Integer wage;

    private Integer companyid;

    private String city;

    private String address;

    private String education;

    private Integer duration;

    private Integer workfrequency;

    private Date updatetime;

    private Integer checkd;

    private String description;

    private Company company ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String[] getTemptation() {
        return temptation;
    }

    public void setTemptation(String[] temptation) {
        this.temptation = temptation;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getWorkfrequency() {
        return workfrequency;
    }

    public void setWorkfrequency(Integer workfrequency) {
        this.workfrequency = workfrequency;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getCheckd() {
        return checkd;
    }

    public void setCheckd(Integer checkd) {
        this.checkd = checkd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
