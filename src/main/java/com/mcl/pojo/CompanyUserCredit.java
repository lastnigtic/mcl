package com.mcl.pojo;

import java.util.Date;

public class CompanyUserCredit {
    private Integer id;

    private String companyid;

    private String openid;

    private Float credit;

    private Date updatetime;

    private String comment;

    public CompanyUserCredit(Integer id, String companyid, String openid, Float credit, Date updatetime, String comment) {
        this.id = id;
        this.companyid = companyid;
        this.openid = openid;
        this.credit = credit;
        this.updatetime = updatetime;
        this.comment = comment;
    }

    public CompanyUserCredit() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
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