package com.mcl.pojo;

import java.util.Date;

public class CompanyUserCredit {
    private Integer id;

    private Integer companyid;

    private String openid;

    private Float credit;

    private Date updatetime;

    public CompanyUserCredit(Integer id, Integer companyid, String openid, Float credit, Date updatetime) {
        this.id = id;
        this.companyid = companyid;
        this.openid = openid;
        this.credit = credit;
        this.updatetime = updatetime;
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

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
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
}