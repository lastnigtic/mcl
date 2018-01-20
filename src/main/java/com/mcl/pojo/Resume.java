package com.mcl.pojo;

import java.util.Date;

public class Resume {
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

    private Date entrytime;

    private String companyname;

    private String jobname;

    private String jobdesc;

    private Date updatetime;

    private Date jobstarttime;

    private Date jobendtime;

    public Resume(Integer id, String openid, String resumename, String avatarurl, String province, String city, String skills, String selfevaluation, String schoolname, String major, Date graduationtime, String education, String majorclass, String certificate, String awards, String campusexp, String jobapplied, String cityapplied, Integer wageapplied, Integer frequencyapplied, Integer durationapplied, Date entrytime, String companyname, String jobname, String jobdesc, Date updatetime, Date jobstarttime, Date jobendtime) {
        this.id = id;
        this.openid = openid;
        this.resumename = resumename;
        this.avatarurl = avatarurl;
        this.province = province;
        this.city = city;
        this.skills = skills;
        this.selfevaluation = selfevaluation;
        this.schoolname = schoolname;
        this.major = major;
        this.graduationtime = graduationtime;
        this.education = education;
        this.majorclass = majorclass;
        this.certificate = certificate;
        this.awards = awards;
        this.campusexp = campusexp;
        this.jobapplied = jobapplied;
        this.cityapplied = cityapplied;
        this.wageapplied = wageapplied;
        this.frequencyapplied = frequencyapplied;
        this.durationapplied = durationapplied;
        this.entrytime = entrytime;
        this.companyname = companyname;
        this.jobname = jobname;
        this.jobdesc = jobdesc;
        this.updatetime = updatetime;
        this.jobstarttime = jobstarttime;
        this.jobendtime = jobendtime;
    }

    public Resume() {
        super();
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
        this.openid = openid == null ? null : openid.trim();
    }

    public String getResumename() {
        return resumename;
    }

    public void setResumename(String resumename) {
        this.resumename = resumename == null ? null : resumename.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills == null ? null : skills.trim();
    }

    public String getSelfevaluation() {
        return selfevaluation;
    }

    public void setSelfevaluation(String selfevaluation) {
        this.selfevaluation = selfevaluation == null ? null : selfevaluation.trim();
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
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
        this.education = education == null ? null : education.trim();
    }

    public String getMajorclass() {
        return majorclass;
    }

    public void setMajorclass(String majorclass) {
        this.majorclass = majorclass == null ? null : majorclass.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards == null ? null : awards.trim();
    }

    public String getCampusexp() {
        return campusexp;
    }

    public void setCampusexp(String campusexp) {
        this.campusexp = campusexp == null ? null : campusexp.trim();
    }

    public String getJobapplied() {
        return jobapplied;
    }

    public void setJobapplied(String jobapplied) {
        this.jobapplied = jobapplied == null ? null : jobapplied.trim();
    }

    public String getCityapplied() {
        return cityapplied;
    }

    public void setCityapplied(String cityapplied) {
        this.cityapplied = cityapplied == null ? null : cityapplied.trim();
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
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc == null ? null : jobdesc.trim();
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
}