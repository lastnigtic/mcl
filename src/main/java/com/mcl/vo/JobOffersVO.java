package com.mcl.vo;

import com.mcl.pojo.CompAvgAbility;
import com.mcl.pojo.Company;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/10 0010.
 */
public class JobOffersVO {
    private Integer id;

    private String jobname;

    private String temptation;

    private String[] tag;

    private String type;

    private Integer wage;

    private String companyid;

    private String city;

    private String address;

    private String education;

    private Integer duration;

    private Integer workfrequency;

    private Date updatetime;

    private Integer checked;

    private String requirements;

    private String description;

    private Company company ;

    private CompAvgAbility compAvgAbility;

    public CompAvgAbility getCompAvgAbility() {
        return compAvgAbility;
    }

    public void setCompAvgAbility(CompAvgAbility compAvgAbility) {
        this.compAvgAbility = compAvgAbility;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

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

    public String getTemptation() {
        return temptation;
    }

    public void setTemptation(String temptation) {
        this.temptation = temptation;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
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

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
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

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
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
