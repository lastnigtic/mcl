package com.mcl.pojo;

import java.util.Date;

public class JobOffers {
    private Integer id;

    private String jobname;

    private String temptation;

    private String tag;

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

    public JobOffers(Integer id, String jobname, String temptation, String tag, String type, Integer wage, String companyid, String city, String address, String education, Integer duration, Integer workfrequency, Date updatetime, Integer checked, String requirements, String description) {
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
        this.requirements = requirements;
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
        this.companyid = companyid == null ? null : companyid.trim();
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

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements == null ? null : requirements.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}