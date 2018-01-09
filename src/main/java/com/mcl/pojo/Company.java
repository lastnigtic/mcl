package com.mcl.pojo;

import java.util.Date;

public class Company {
    private Integer id;

    private String city;

    private String imgurl;

    private String companysize;

    private String address;

    private Date updatetime;

    private Integer checked;

    private Double credit;

    private String introduction;

    public Company(Integer id, String city, String imgurl, String companysize, String address, Date updatetime, Integer checked, Double credit, String introduction) {
        this.id = id;
        this.city = city;
        this.imgurl = imgurl;
        this.companysize = companysize;
        this.address = address;
        this.updatetime = updatetime;
        this.checked = checked;
        this.credit = credit;
        this.introduction = introduction;
    }

    public Company() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getCompanysize() {
        return companysize;
    }

    public void setCompanysize(String companysize) {
        this.companysize = companysize == null ? null : companysize.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}