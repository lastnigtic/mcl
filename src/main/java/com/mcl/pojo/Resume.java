package com.mcl.pojo;

import java.util.Date;

public class Resume {
    private Integer id;

    private String openid;

    private String skills;

    private String hobbies;

    private String selfevaluation;

    private Date updatetime;

    public Resume(Integer id, String openid, String skills, String hobbies, String selfevaluation, Date updatetime) {
        this.id = id;
        this.openid = openid;
        this.skills = skills;
        this.hobbies = hobbies;
        this.selfevaluation = selfevaluation;
        this.updatetime = updatetime;
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
}