package com.mcl.pojo;

import java.util.Date;

public class CompanyScore {
    private Integer id;

    private String openid;

    private Integer joid;

    private String companyid;

    private Date updatetime;

    private String comment;

    private Integer creditrate;

    private Integer atmosphererate;

    private Integer environmentrate;

    private Integer wagerate;

    public CompanyScore(Integer id, String openid, Integer joid, String companyid, Date updatetime, String comment, Integer creditrate, Integer atmosphererate, Integer environmentrate, Integer wagerate) {
        this.id = id;
        this.openid = openid;
        this.joid = joid;
        this.companyid = companyid;
        this.updatetime = updatetime;
        this.comment = comment;
        this.creditrate = creditrate;
        this.atmosphererate = atmosphererate;
        this.environmentrate = environmentrate;
        this.wagerate = wagerate;
    }

    public CompanyScore() {
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

    public Integer getCreditrate() {
        return creditrate;
    }

    public void setCreditrate(Integer creditrate) {
        this.creditrate = creditrate;
    }

    public Integer getAtmosphererate() {
        return atmosphererate;
    }

    public void setAtmosphererate(Integer atmosphererate) {
        this.atmosphererate = atmosphererate;
    }

    public Integer getEnvironmentrate() {
        return environmentrate;
    }

    public void setEnvironmentrate(Integer environmentrate) {
        this.environmentrate = environmentrate;
    }

    public Integer getWagerate() {
        return wagerate;
    }

    public void setWagerate(Integer wagerate) {
        this.wagerate = wagerate;
    }
}