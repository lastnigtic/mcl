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

    private String city;

    private String address;

    private String education;

    private String duration;

    private String workfrequency;

    private Date updatetime;

    private Integer checked;

    private String description;

    public JobOffers(Integer id, String jobname, String temptation, String tag, String type, String wage, Integer companyid, String city, String address, String education, String duration, String workfrequency, Date updatetime, Integer checked, String description) {
        this.id = id;
        this.jobname = jobname;
        this.temptation = temptation;
        this.tag = tag;
        this.type = type;
        this.wage = wage;
        this.companyid = companyid;
        this.city = city;
        this.address = address;
        this.education = education;
        this.duration = duration;
        this.workfrequency = workfrequency;
        this.updatetime = updatetime;
        this.checked = checked;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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
        this.description = description == null ? null : description.trim();
    }
}