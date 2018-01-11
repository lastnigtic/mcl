package com.mcl.pojo;

import java.util.Date;

public class Resume {
    private Integer id;

    private String openid;

    private String skills;

    private String hobbies;

    private String selfevaluation;

    private Date updatetime;

    private String schoolname;

    private String major;

    private Date startschooltime;

    private Date endschooltime;

    private String education;


    private String majorclass;

    private String certificate;

    private String awards;

    private String campusexp;

    public Resume(Integer id, String openid, String skills, String hobbies, String selfevaluation, Date updatetime, String schoolname, String major, Date startschooltime, Date endschooltime, String education, String majorclass, String certificate, String awards, String campusexp) {
        this.id = id;
        this.openid = openid;
        this.skills = skills;
        this.hobbies = hobbies;
        this.selfevaluation = selfevaluation;
        this.updatetime = updatetime;
        this.schoolname = schoolname;
        this.major = major;
        this.startschooltime = startschooltime;
        this.endschooltime = endschooltime;
        this.education = education;
        this.majorclass = majorclass;
        this.certificate = certificate;
        this.awards = awards;
        this.campusexp = campusexp;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills == null ? null : skills.trim();
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies == null ? null : hobbies.trim();
    }

    public String getSelfevaluation() {
        return selfevaluation;
    }

    public void setSelfevaluation(String selfevaluation) {
        this.selfevaluation = selfevaluation == null ? null : selfevaluation.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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

    public Date getStartschooltime() {
        return startschooltime;
    }

    public void setStartschooltime(Date startschooltime) {
        this.startschooltime = startschooltime;
    }

    public Date getEndschooltime() {
        return endschooltime;
    }

    public void setEndschooltime(Date endschooltime) {
        this.endschooltime = endschooltime;
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
}