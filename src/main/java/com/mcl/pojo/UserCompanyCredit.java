package com.mcl.pojo;

import java.util.Date;

public class UserCompanyCredit {
    private Integer id;

    private Integer companyid;

    private String openid;

    private Double credit;

    private Date uodatetime;

    public UserCompanyCredit(Integer id, Integer companyid, String openid, Double credit, Date uodatetime) {
        this.id = id;
        this.companyid = companyid;
        this.openid = openid;
        this.credit = credit;
        this.uodatetime = uodatetime;
    }

    public UserCompanyCredit() {
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

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Date getUodatetime() {
        return uodatetime;
    }

    public void setUodatetime(Date uodatetime) {
        this.uodatetime = uodatetime;
    }
}