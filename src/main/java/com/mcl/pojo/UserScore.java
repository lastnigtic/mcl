package com.mcl.pojo;

import java.util.Date;

public class UserScore {
    private Integer id;

    private String openid;

    private Integer organizationability;

    private Integer communicateability;

    private Integer technicalability;

    private Integer adaptability;

    private Integer innovationability;

    private Integer learnability;

    private Integer joid;

    private String companyid;

    private Date updatetime;

    private String comment;

    public UserScore(Integer id, String openid, Integer organizationability, Integer communicateability, Integer technicalability, Integer adaptability, Integer innovationability, Integer learnability, Integer joid, String companyid, Date updatetime, String comment) {
        this.id = id;
        this.openid = openid;
        this.organizationability = organizationability;
        this.communicateability = communicateability;
        this.technicalability = technicalability;
        this.adaptability = adaptability;
        this.innovationability = innovationability;
        this.learnability = learnability;
        this.joid = joid;
        this.companyid = companyid;
        this.updatetime = updatetime;
        this.comment = comment;
    }

    public UserScore() {
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

    public Integer getOrganizationability() {
        return organizationability;
    }

    public void setOrganizationability(Integer organizationability) {
        this.organizationability = organizationability;
    }

    public Integer getCommunicateability() {
        return communicateability;
    }

    public void setCommunicateability(Integer communicateability) {
        this.communicateability = communicateability;
    }

    public Integer getTechnicalability() {
        return technicalability;
    }

    public void setTechnicalability(Integer technicalability) {
        this.technicalability = technicalability;
    }

    public Integer getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Integer adaptability) {
        this.adaptability = adaptability;
    }

    public Integer getInnovationability() {
        return innovationability;
    }

    public void setInnovationability(Integer innovationability) {
        this.innovationability = innovationability;
    }

    public Integer getLearnability() {
        return learnability;
    }

    public void setLearnability(Integer learnability) {
        this.learnability = learnability;
    }

    public Integer getJoid() {
        return joid;
    }

    public void setJoid(Integer joid) {
        this.joid = joid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}