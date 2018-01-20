package com.mcl.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class InterviewInfo {
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date interviewtime;

    private Integer joid;

    private Date updatetime;

    private Integer viewd;

    private String description;

    public InterviewInfo(Integer id, Date interviewtime, Integer joid, Date updatetime, Integer viewd, String description) {
        this.id = id;
        this.interviewtime = interviewtime;
        this.joid = joid;
        this.updatetime = updatetime;
        this.viewd = viewd;
        this.description = description;
    }

    public InterviewInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInterviewtime() {
        return interviewtime;
    }

    public void setInterviewtime(Date interviewtime) {
        this.interviewtime = interviewtime;
    }

    public Integer getJoid() {
        return joid;
    }

    public void setJoid(Integer joid) {
        this.joid = joid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getViewd() {
        return viewd;
    }

    public void setViewd(Integer viewd) {
        this.viewd = viewd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}