package com.mcl.pojo;

import java.util.Date;

public class JobOffers {
    private Integer id;

    private String jobname;

    private String temptation;

    private String tag;

    private String type;

    private String wage;

    private Integer companyid;

    private String cityCountry;

    private String address;

    private String education;

    private String duration;

    private String workfrequency;

    private Date updatetime;

    private Integer checkd;

    private String description;

    public JobOffers(Integer id, String jobname, String temptation, String tag, String type, String wage, Integer companyid, String cityCountry, String address, String education, String duration, String workfrequency, Date updatetime, Integer checkd, String description) {
        this.id = id;
        this.jobname = jobname;
        this.temptation = temptation;
        this.tag = tag;
        this.type = type;
        this.wage = wage;
        this.companyid = companyid;
        this.cityCountry = cityCountry;
        this.address = address;
        this.education = education;
        this.duration = duration;
        this.workfrequency = workfrequency;
        this.updatetime = updatetime;
        this.checkd = checkd;
        this.description = description;
    }

    public JobOffers() {
        super();
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
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public String getTemptation() {
        return temptation;
    }

    public void setTemptation(String temptation) {
        this.temptation = temptation == null ? null : temptation.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage == null ? null : wage.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public void setCityCountry(String cityCountry) {
        this.cityCountry = cityCountry == null ? null : cityCountry.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getWorkfrequency() {
        return workfrequency;
    }

    public void setWorkfrequency(String workfrequency) {
        this.workfrequency = workfrequency == null ? null : workfrequency.trim();
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
        this.description = description == null ? null : description.trim();
    }
}