package com.mcl.pojo;

import java.util.Date;

public class CompanyMsg {
    private Integer id;

    private String title;

    private String content;

    private Integer type;

    private Integer status;

    private Date updatetime;

    private String companyid;

    private Integer joid ;

    public CompanyMsg(){
        
    }

    public CompanyMsg(Integer id, String title, String content, Integer type, Integer status, Date updatetime, String companyid, Integer joid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.status = status;
        this.updatetime = updatetime;
        this.companyid = companyid;
        this.joid = joid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public Integer getJoid() {
        return joid;
    }

    public void setJoid(Integer joid) {
        this.joid = joid;
    }
}