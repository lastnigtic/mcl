package com.mcl.pojo;

import java.util.Date;

public class Company {
    private String id;

    private String city;

    private String imgurl;

    private String companysize;

    private String introduction;

    private String address;

    private Date updatetime;

    private Integer checked;

    private Double credit;

    private String companyname;

    private String companylicense;

    private Date setuptime;

    private Integer registeredcapital;

    private String legalrepresentative;

    private String website;

    private String financingstage;

    private String industry;

    public Company(String id, String city, String imgurl, String companysize, String introduction, String address, Date updatetime, Integer checked, Double credit, String companyname, String companylicense, Date setuptime, Integer registeredcapital, String legalrepresentative, String website, String financingstage, String industry) {
        this.id = id;
        this.city = city;
        this.imgurl = imgurl;
        this.companysize = companysize;
        this.introduction = introduction;
        this.address = address;
        this.updatetime = updatetime;
        this.checked = checked;
        this.credit = credit;
        this.companyname = companyname;
        this.companylicense = companylicense;
        this.setuptime = setuptime;
        this.registeredcapital = registeredcapital;
        this.legalrepresentative = legalrepresentative;
        this.website = website;
        this.financingstage = financingstage;
        this.industry = industry;
    }

    public Company() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCompanylicense() {
        return companylicense;
    }

    public void setCompanylicense(String companylicense) {
        this.companylicense = companylicense == null ? null : companylicense.trim();
    }

    public Date getSetuptime() {
        return setuptime;
    }

    public void setSetuptime(Date setuptime) {
        this.setuptime = setuptime;
    }

    public Integer getRegisteredcapital() {
        return registeredcapital;
    }

    public void setRegisteredcapital(Integer registeredcapital) {
        this.registeredcapital = registeredcapital;
    }

    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative == null ? null : legalrepresentative.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getFinancingstage() {
        return financingstage;
    }

    public void setFinancingstage(String financingstage) {
        this.financingstage = financingstage == null ? null : financingstage.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }
}