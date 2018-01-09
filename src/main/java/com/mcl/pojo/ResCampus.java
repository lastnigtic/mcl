package com.mcl.pojo;

import java.util.Date;

public class ResCampus {
    private Integer id;

    private Integer reid;

    private String organizationname;

    private String position;

    private Date starttime;

    private Date endtime;

    private String description;

    public ResCampus(Integer id, Integer reid, String organizationname, String position, Date starttime, Date endtime, String description) {
        this.id = id;
        this.reid = reid;
        this.organizationname = organizationname;
        this.position = position;
        this.starttime = starttime;
        this.endtime = endtime;
        this.description = description;
    }

    public ResCampus() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}