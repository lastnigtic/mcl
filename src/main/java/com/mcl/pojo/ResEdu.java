package com.mcl.pojo;

import java.util.Date;

public class ResEdu {
    private Integer id;

    private Integer reid;

    private String schoolname;

    private String major;

    private Date startschooltime;

    private Date endschooltime;

    private String education;

    private String majorclass;

    private String certificate;

    private String awards;

    public ResEdu(Integer id, Integer reid, String schoolname, String major, Date startschooltime, Date endschooltime, String education, String majorclass, String certificate, String awards) {
        this.id = id;
        this.reid = reid;
        this.schoolname = schoolname;
        this.major = major;
        this.startschooltime = startschooltime;
        this.endschooltime = endschooltime;
        this.education = education;
        this.majorclass = majorclass;
        this.certificate = certificate;
        this.awards = awards;
    }

    public ResEdu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
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
}