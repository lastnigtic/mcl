package com.mcl.vo;

import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.ResDeliverStatus;
import com.mcl.pojo.UserBaseInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/21 0021.
 */
public class ResumeVO {
    private Integer id;

    private String openid;

    private String resumename;

    private String avatarurl;

    private String province;

    private String city;

    private String skills;

    private String selfevaluation;

    private String schoolname;

    private String major;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graduationtime;

    private String education;

    private String majorclass;

    private String certificate;

    private String awards;

    private String campusexp;

    private String jobapplied;

    private String cityapplied;

    private Integer wageapplied;

    private Integer frequencyapplied;

    private Integer durationapplied;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entrytime;

    private String companyname;

    private String jobname;

    private String jobdesc;

    private Date updatetime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jobstarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jobendtime;

    private UserBaseInfo userBaseInfo ;

    private ResDeliverStatus resDeliverStatus ;

    private Company company ;

    private JobOffers jobOffers ;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getResumename() {
        return resumename;
    }

    public void setResumename(String resumename) {
        this.resumename = resumename;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSelfevaluation() {
        return selfevaluation;
    }

    public void setSelfevaluation(String selfevaluation) {
        this.selfevaluation = selfevaluation;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getGraduationtime() {
        return graduationtime;
    }

    public void setGraduationtime(Date graduationtime) {
        this.graduationtime = graduationtime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajorclass() {
        return majorclass;
    }

    public void setMajorclass(String majorclass) {
        this.majorclass = majorclass;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getCampusexp() {
        return campusexp;
    }

    public void setCampusexp(String campusexp) {
        this.campusexp = campusexp;
    }

    public String getJobapplied() {
        return jobapplied;
    }

    public void setJobapplied(String jobapplied) {
        this.jobapplied = jobapplied;
    }

    public String getCityapplied() {
        return cityapplied;
    }

    public void setCityapplied(String cityapplied) {
        this.cityapplied = cityapplied;
    }

    public Integer getWageapplied() {
        return wageapplied;
    }

    public void setWageapplied(Integer wageapplied) {
        this.wageapplied = wageapplied;
    }

    public Integer getFrequencyapplied() {
        return frequencyapplied;
    }

    public void setFrequencyapplied(Integer frequencyapplied) {
        this.frequencyapplied = frequencyapplied;
    }

    public Integer getDurationapplied() {
        return durationapplied;
    }

    public void setDurationapplied(Integer durationapplied) {
        this.durationapplied = durationapplied;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getJobstarttime() {
        return jobstarttime;
    }

    public void setJobstarttime(Date jobstarttime) {
        this.jobstarttime = jobstarttime;
    }

    public Date getJobendtime() {
        return jobendtime;
    }

    public void setJobendtime(Date jobendtime) {
        this.jobendtime = jobendtime;
    }

    public UserBaseInfo getUserBaseInfo() {
        return userBaseInfo;
    }

    public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }

    public ResDeliverStatus getResDeliverStatus() {
        return resDeliverStatus;
    }

    public void setResDeliverStatus(ResDeliverStatus resDeliverStatus) {
        this.resDeliverStatus = resDeliverStatus;
    }

    public JobOffers getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(JobOffers jobOffers) {
        this.jobOffers = jobOffers;
    }

}
