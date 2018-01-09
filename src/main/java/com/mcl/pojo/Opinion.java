package com.mcl.pojo;

import java.util.Date;

public class Opinion {
    private Integer id;

    private String openid;

    private Date updatetime;

    private String contactinfo;

    private String description;

    public Opinion(Integer id, String openid, Date updatetime, String contactinfo, String description) {
        this.id = id;
        this.openid = openid;
        this.updatetime = updatetime;
        this.contactinfo = contactinfo;
        this.description = description;
    }

    public Opinion() {
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo == null ? null : contactinfo.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}