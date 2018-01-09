package com.mcl.pojo;

import java.util.Date;

public class ResDeliverStatus {
    private Integer id;

    private Integer joid;

    private Integer reid;

    private Integer status;

    private Integer viewed;

    private Date updatetime;

    private String openid;

    private String description;

    public ResDeliverStatus(Integer id, Integer joid, Integer reid, Integer status, Integer viewed, Date updatetime, String openid, String description) {
        this.id = id;
        this.joid = joid;
        this.reid = reid;
        this.status = status;
        this.viewed = viewed;
        this.updatetime = updatetime;
        this.openid = openid;
        this.description = description;
    }

    public ResDeliverStatus() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJoid() {
        return joid;
    }

    public void setJoid(Integer joid) {
        this.joid = joid;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getViewed() {
        return viewed;
    }

    public void setViewed(Integer viewed) {
        this.viewed = viewed;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}