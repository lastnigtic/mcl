package com.mcl.pojo;

import java.util.Date;

public class Company {
    private String id;

    private String city;

    private String imgurl;

    private String companysize;

    private String address;

    private Date updatetime;

    private Integer checked;

    private Double credit;

    private String introduction;

    private String companyname ;

    private String companylicense ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCompanysize() {
        return companysize;
    }

    public void setCompanysize(String companysize) {
        this.companysize = companysize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        this.introduction = introduction;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanylicense() {
        return companylicense;
    }

    public void setCompanylicense(String companylicense) {
        this.companylicense = companylicense;
    }
}